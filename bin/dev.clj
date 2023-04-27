(ns dev
  (:require [babashka.tasks :refer [shell]]
            [pod.babashka.fswatcher :as fw]))

(defn watch []
  (letfn [(f [{:keys [type _path] :as _event}]
            (when (= :write type)
              (println "Write detected. Regenerating pages.")
              (shell "bb gen")
              (println "And opening...")
              ;; FIXME: improvement: reload current tab if already open
              (shell "xdg-open" "publish/index.html")))]
    (fw/watch "src" f {:delay-ms 50, :recursive true})
    (fw/watch "assets" f {:delay-ms 50, :recursive true}))

  (println "Watching current directory for changes. Ctrl-C to quit.")
  @(promise))
