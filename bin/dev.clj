(ns dev
  (:require [clojure.java.shell :refer [sh]]
            [pod.babashka.fswatcher :as fw]))

(defn watch []
  (fw/watch "."
            (fn [{:keys [type path] :as _event}]
              (when (= :write type)
                (println "Write detected. Regenerating pages.")
                (sh "bb gen-pages")))
            {:delay-ms 50})

  (println "Watching /pages for changes. Ctrl-C to quit.")
  @(promise))
