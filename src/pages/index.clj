(ns pages.index
  (:require [components.core :as core]))


(def body
  [:body
   #_core/header
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
    [:a.waitlist {:href "https://docs.google.com/forms/d/e/1FAIpQLScOSpyNqZNCFY-QvRAavbldD4CAe9yGYZiI1vzE9PUZVYihFA/viewform?usp=sf_link"}
     [:h3 "join the waitlist"]]]
   #_[:div.features
    (core/feature {:heading "foo", :text "bar baz etc."}
                  {:text "fkladsjdlfk;asjd"
                   :tags [:foo.bar/baz]})
    (core/feature {:heading "foo", :text "bar baz etc."}
                  {:text "fkladsjdlfk;asjd"
                   :tags [:foo.bar/baz]}
                  false)]])
