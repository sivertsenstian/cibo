(ns cibo.client.views.application
 (:require [re-frame.core                       :as re-frame]
           [cibo.client.views.recipes.index     :as recipes]
           [cibo.client.views.recipes.show      :as show-recipe]
           [cibo.client.views.menus.index       :as menus]
           [cibo.client.views.menus.show        :as show-menu]
           [cibo.client.html.application.header :as application-header]))

(defn- render-view [view]
  (case view
    :show-recipe [show-recipe/render]
    :recipes [recipes/render]
    :show-menu [show-menu/render]
    :menus [menus/render]
    [:div.h3 "404 - Not found"]))

(defn render []
  (let [view (re-frame/subscribe [:selected :view])]
    (fn []
      [:div.ui.grid.container
       [:div.row>div.sixteen.wide.column
        [application-header/render]]
       [:div.row>div.sixteen.wide.column
        [render-view @view]]])))
