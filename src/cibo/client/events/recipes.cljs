(ns cibo.client.events.recipes
  (:require [re-frame.core            :as re-frame]
            [cibo.client.utility.rest :as REST]))

(re-frame/reg-event-db
 :request-recipes
 (fn request-recipes [state _]
  (REST/recipes {:handler #(re-frame/dispatch [:recieve-recipes %])})
  state))

(re-frame/reg-event-db
 :recieve-recipes
 (fn recieve-recipes [state [_ recipes]]
  (assoc state :recipes recipes)))
