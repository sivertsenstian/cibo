(ns cibo.client.events.application
 (:require [re-frame.core     :as re-frame]
           [cibo.client.state :as state]))

(re-frame/reg-event-db
 :initialize-application
 (fn  [_ _]
  state/initial))

(re-frame/reg-event-db
 :select
 (fn [state [_ key value]]
  (assoc-in state [:selected key] value)))

(re-frame/reg-event-db
 :deselect
 (fn [state [_ key]]
  (update-in state [:selected] dissoc key)))
