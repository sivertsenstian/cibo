(ns cibo.api.handler
  (:require [compojure.core                  :refer [GET defroutes]]
            [compojure.route                 :refer [resources]]
            [ring.util.response              :refer [resource-response response not-found]]
            [ring.middleware.reload          :refer [wrap-reload]]
            [ring.middleware.format-params   :refer [wrap-restful-params]]
            [ring.middleware.format-response :refer [wrap-restful-response]]
            [cibo.api.database               :as db]))

(defroutes routes
  (GET "/users" [] (response (db/all-users)))
  (GET "/recipes" [] (response (db/all-recipes)))
  (GET "/menus" [] (response (db/all-menus)))

  (GET "/" [] (resource-response "index.html" {:root "public"}))
  (resources "/"))

(def reloadable-handler
 (-> routes
  (wrap-restful-params)
  (wrap-restful-response)
  (wrap-reload)))

(def handler routes)
