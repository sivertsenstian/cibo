(ns cibo.client.html.application.header
  (:require [cibo.client.routing :as routing]))

(defn render []
  [:div.ui.secondary.pointing.menu
   [:span {:on-click #(routing/navigate! "/")}
    [:img {:height 35 :src "/img/icon.png"}]]
   [:a.item {:on-click #(routing/navigate! "/recipes")} "recipes"]
   [:a.item {:on-click #(routing/navigate! "/menus")} "menus"]
   [:div.right.menu
    [:a.ui.item [:i.user.icon] " Logout"]]])
