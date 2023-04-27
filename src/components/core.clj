(ns components.core
  (:require [utils.tags :refer [tag->str]]))

(def header
  [:div.header
   [:div.logo
    [:h2 "WattDo?⚡"]]
   [:div.nav
    [:a {:href "./pricing.html"} [:h3 "Pricing"]]
    [:a {:href "./pricing.html"} [:h3 "Foo"]]
    [:a {:href "./pricing.html"} [:h3 "Bar"]]]])

(defn tag [tag]
  [:div.tag
   [:p (tag->str tag)]])

(defn card [{:keys [text tags link]}]
  [:div.card
   [:p.text text]
   [:div.tags
    (for [t tags]
      (tag t))]
   (when link
     [:a {:href link}
      link])])
