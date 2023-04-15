(ns components.core)

(def header
  [:div.header
   [:div.logo
    [:h2 "WattDo?⚡"]]
   [:div.nav
    [:a {:href "./pricing.html"} [:h3 "Pricing"]]
    [:a {:href "./pricing.html"} [:h3 "Foo"]]
    [:a {:href "./pricing.html"} [:h3 "Bar"]]]])
