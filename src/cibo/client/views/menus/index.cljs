(ns cibo.client.views.menus.index
 (:require [re-frame.core       :as re-frame]
           [cibo.client.routing :as routing]))

(defn render []
  (let [menus (re-frame/subscribe [:menus])]
    (fn []
      [:div
       [:table.ui.celled.table
        [:thead>tr
         [:th "#"]
         [:th "Name"]]
        [:tbody
         (map-indexed
          (fn [index menu]
            ^{:key (str "menu-" (menu :id))}
            [:tr {:on-click #(routing/navigate! "/menus/" (menu :id))}
             [:td (inc index)]
             [:td (menu :name)]])
          @menus)]]])))
