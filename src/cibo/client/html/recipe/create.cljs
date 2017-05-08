(ns cibo.client.html.recipe.create
 (:require [re-frame.core :as re-frame]))

(defn render []
  [:div
   [:div.ui.form
    [:div.two.inline.fields
     [:div.three.wide.field
      [:label "Name"]
      [:div
       [:input {:type "text" :placeholder "recipe name..."}]]]
     [:div.three.wide.field
      [:div.primary.ui.button "Add"]]]]])

