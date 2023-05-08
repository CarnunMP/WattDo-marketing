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

(defn card [{:keys [text tags link visible?]}]
  [:div (cond-> {:class "card"}
          visible? (update :class str " visible"))
   [:h3.text text]
   [:div.tags
    (for [t tags]
      (tag t))]
   (when link
     [:a {:href link}
      link])])

(defn feature
  ([feature-args card-args] (feature feature-args card-args true))
  ([{:keys [heading text]} card-args left?]
   [:div {:class (str "feature " (if left? "l" "r"))}
    (when left?
      (card card-args))
    [:div.text
     [:h2 heading]
     [:p text]]
    (when-not left?
      (card card-args))]))
