(ns cibo.client.events.menus
  (:require [re-frame.core            :as re-frame]
            [cibo.client.utility.rest :as REST]))

(re-frame/reg-event-db
 :request-menus
 (fn request-menus [state _]
  (REST/menus {:handler #(re-frame/dispatch [:recieve-menus %])})
  state))

(re-frame/reg-event-db
 :recieve-menus
 (fn recieve-menus [state [_ menus]]
  (assoc state :menus menus)))
