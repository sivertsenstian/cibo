(ns cibo.client.subscriptions.application
 (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :selected
 (fn [state [_ key]]
  (-> state :selected key)))
