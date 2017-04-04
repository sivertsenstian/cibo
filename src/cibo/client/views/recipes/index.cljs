(ns cibo.client.views.recipes.index
 (:require [re-frame.core       :as re-frame]
           [cibo.client.routing :as routing]))

(defn render []
  (let [recipes (re-frame/subscribe [:recipes])]
    (fn []
      [:div
       [:table.ui.celled.table
        [:thead>tr
         [:th "#"]
         [:th "Name"]]
        [:tbody
         (map-indexed
          (fn [index recipe]
            ^{:key (str "recipe-" (recipe :id))}
            [:tr {:on-click #(routing/navigate! "/recipes/" (recipe :id))}
             [:td (inc index)]
             [:td (recipe :name)]])
          @recipes)]]])))
