(ns pages.index
  (:require [components.core :as core]))


(def body
  [:body
   core/header
   [:div.banner
    [:h1 "WattDo?⚡"]
    (core/card {:text "capture and direct moments of inspiration towards ambitious, emergent ends"
                :tags [:fun :flow :productivity]})]
   [:div.ctas
    [:div.platforms
     [:div.platform-button
      [:img {:src "../assets/web.png"}]
      [:p "COMING SOON"]]
     [:div.platform-button
      [:img {:src "../assets/apple.svg"}]
      [:p "COMING SOON"]]
     [:div.platform-button
      [:img {:src "../assets/android.png"}]
      [:p "COMING SOON"]]]
    [:a.waitlist {:href "https://iphg8uqckwl.typeform.com/to/HeB32ndu"}
     [:h3 "join the waitlist"]]]])
