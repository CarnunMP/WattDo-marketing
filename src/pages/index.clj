(ns pages.index
  (:require [components.core :as core]))


(def body
  [:body
   core/header
   [:div.banner
    [:h1 "WattDo?⚡"]
    (core/card {:text "capture and direct moments of inspiration towards ambitious, emergent ends"
                :tags [:fun :flow :productivity]})]])
