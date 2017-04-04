(ns cibo.client.subscriptions.recipes
 (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :recipes
 (fn [state _]
  (state :recipes)))
