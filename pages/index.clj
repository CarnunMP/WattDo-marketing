(ns index)


(def body
  [:body
   [:div
    (for [i (range 3)]
      [:h1 (str i ": Using Bootleg From Babashka")])
    [:p "This is a demo"]]])
