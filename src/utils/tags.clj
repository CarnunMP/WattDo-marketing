(ns utils.tags
  (:require [clojure.string :as str]))

(defn tag->str [tag]
  {:pre [(keyword tag)]}
  (-> (str tag)
      (str/replace #":|\.|/" {":" "#", "." "➡", "/" "➡"})))
