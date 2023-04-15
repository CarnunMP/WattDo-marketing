(ns pages.index
  (:require [components.core :as core]))


(def body
  [:body
   core/header
   [:div
    (for [i (range 3)]
      [:h1 (str i ": Using Bootleg From Babashka")])
    [:p "This is a demo"]]])
