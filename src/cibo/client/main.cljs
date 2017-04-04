(ns cibo.client.main
  (:require [reagent.core                    :as r]
            [re-frame.core                   :as re-frame]
            [cibo.client.routing             :as routing]
            [cibo.client.views.application   :as application]
            [cibo.client.events.application]
            [cibo.client.events.recipes]
            [cibo.client.events.menus]
            [cibo.client.subscriptions.application]
            [cibo.client.subscriptions.recipes]
            [cibo.client.subscriptions.menus]))


(def debug?
  ^boolean js/goog.DEBUG)

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "ѫѫѫ you are developing ѫѫѫ")))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (r/render [application/render]
   (.getElementById js/document "cibo")))

(defn ^:export init []
  (routing/routes)
  (re-frame/dispatch-sync [:initialize-application])
  (dev-setup)
  (mount-root))
