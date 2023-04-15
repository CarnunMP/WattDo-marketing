(ns gen
  "As in 'generation'. This approach is inspired by https://github.com/mmzsource/mxmmz/blob/master/gen.clj :)"
  (:require [babashka.fs :as fs]
            [clojure.string :as str]
            [pod.retrogradeorbit.bootleg.utils :as bootleg.utils]))


;;; --- HTML boilerplate ---

(defn parse-page-body [hiccup-body]
  {:pre [(vector? hiccup-body) (= :body (first hiccup-body))]}
  (-> [:html {:lang "en"}
       [:head
        [:meta {:charset "utf-8"}]
        [:meta {:name "viewport" :content "width=device-width,initial-scale=1"}]
        [:title "WattDo?⚡"]
        [:link {:rel "stylesheet" :href "/styles/app.css?v=2"}]
        ;[:link {:rel "icon" :type "image/x-icon" :href "/assets/cmp.ico"}]
        ]
       hiccup-body]
      (bootleg.utils/convert-to :html)
      (->> (str "<!DOCTYPE html>\n"))))

;; main idea is:
;; functions and hiccup in /pages
;; use bootleg to turn them into HTML files and copy to pages

;;

(defn reset-publish-dir! []
  (fs/delete-tree "publish")
  (fs/create-dir "publish"))

(defn copy-css! []
  (fs/copy-tree "styles" "publish/styles"))

(defn parse-and-copy-pages! []
  ;; for each page
  ;; grab body and parse
  (doseq [f (fs/list-dir "pages")]
    (prn (str f))
    (let [n (re-find #"(?<=pages/).+(?=\.clj)" (str f))
          sym (-> n
                  (str/replace #"_" "-")
                  symbol)
          _ (require sym)
          page (parse-page-body @(ns-resolve sym 'body))]
      (if (= "index" n)
        (spit "publish/index.html" page)
        (spit (str "publish/" n ".html") page)))))

(defn update-publish-dir []
  (reset-publish-dir!)
  (copy-css!)
  (parse-and-copy-pages!)
  )
