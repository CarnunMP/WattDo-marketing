(ns pages.index
  (:require [components.core :as core]))


(def card-args [{:text "discover what you're \"HELL YEAH!\" about and do it, now"
                 :tags [:fun :flow :productivity]
                 :visible? true}
                {:text "capture and direct moments of inspiration towards ambitious, emergent ends"
                 :tags [:explore :motivate]}
                {:text "climb mountains: one small, happy step at a time"
                 :tags [:projects :long-games]}])

;; TODO: Scittle would be nicer! :P
(defn move-carosel-fn [d]
  (str "let cardsEl = this.parentElement;"
       "let cards = Array.from(cardsEl.querySelectorAll('.card'));"
       "let visibleIndex = cards.findIndex(e => e.classList.contains('visible'));"
       "cards[visibleIndex].classList.remove('visible');"
       "visibleIndex = '" d "' == ':left' ? (((visibleIndex - 1) + cards.length) % cards.length) : ((visibleIndex + 1) % cards.length);"
       "cards[visibleIndex].classList.add('visible');"))

(def body
  [:body
   #_core/header
   [:div.banner
    [:h1 "watt.do⚡"]
    [:div.cards {:data-visible-n 0}
     [:div.arrow.left {:onclick (move-carosel-fn :left)}
      [:h2 "⬅"]]
     (for [args card-args]
       (core/card args))
     [:div.arrow.right {:onclick (move-carosel-fn :right)}
      [:h2 "➡"]]]]
   [:div.main
    [:div.later
     [:div.platform-button
      [:img {:src "./assets/apple.svg"}]
      [:p "COMING SOON"]]
     [:div.platform-button
      [:img {:src "./assets/android.png"}]
      [:p "COMING SOON"]]]
    [:div.mvp
     [:h3 "COMING SOONER"]
     [:div.buttons
      [:div.platform-button
       [:img {:src "./assets/web.png"}]
       [:h3 "web app"]]
      [:h1 "+"]
      [:div.platform-button
       [:img {:src "./assets/extension.png"}]
       [:h3 "extension"]]]]
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
