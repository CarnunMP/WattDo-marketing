(ns gen
  "As in 'generation'."
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
        [:title "watt.do⚡"]
        [:link {:rel "preconnect", :href "https://fonts.googleapis.com"}]
        [:link {:rel "preconnect", :href="https://fonts.gstatic.com" :crossorigin true}]
        [:link {:rel "stylesheet" :href "https://fonts.googleapis.com/css2?family=Electrolize&display=swap"}]
        [:link {:rel "stylesheet" :href "./styles/reset.css?v=2"}]
        [:link {:rel "stylesheet" :href "./styles/app.css?v=2"}]
        ;[:link {:rel "icon" :type "image/x-icon" :href "/assets/cmp.ico"}]
        ]
       hiccup-body]
      (bootleg.utils/convert-to :html)
      (->> (str "<!DOCTYPE html>\n"))))


;;; --- publish ---

(defn reset-publish-dir! []
  (when (fs/exists? "publish")
    (doseq [f (fs/list-dir "publish")]
      (when-not (#{"publish/.git" "publish/CNAME"} (str f))
        (fs/delete-tree (str f))))))

(defn copy-css! []
  (fs/copy-tree "src/styles" "publish/styles"))

(defn copy-assets! []
  (fs/copy-tree "assets" "publish/assets"))

(defn parse-and-copy-pages! []
  (doseq [f (fs/list-dir "src/pages")]
    (let [n (re-find #"pages/.+(?=\.clj)" (str f))
          sym (-> n
                  (str/replace #"_" "-")
                  (str/replace #"/" ".")
                  symbol)
          _ (require sym)
          page (parse-page-body @(ns-resolve sym 'body))]
      (spit (str "publish/" (re-find #"(?<=pages/).+" n) ".html") page))))

(defn update-publish-dir []
  (reset-publish-dir!)
  (copy-css!)
  (copy-assets!)
  (parse-and-copy-pages!))
