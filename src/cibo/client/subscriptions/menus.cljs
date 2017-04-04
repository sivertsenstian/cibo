(ns cibo.client.subscriptions.menus
 (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :menus
 (fn [state _]
  (state :menus)))
