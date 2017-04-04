(ns cibo.client.utility.rest
  (:require [ajax.core :refer [GET POST PUT DELETE]]))

;;RECIPES
(defn recipes [options]
 (GET "/recipes" options))

;;MENUS
(defn menus [options]
 (GET "/menus" options))
