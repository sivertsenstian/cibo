(ns cibo.api.database
 (:require [korma.db   :as db :refer [defdb]]
           [korma.core :as k :refer [defentity]]))

(defdb cibo-db (db/sqlite3 {:db "cibo.db"}))

(defentity users)
(defentity recipes)
(defentity menus)


(defn all-users [] (k/select users))

(defn all-recipes [] (k/select recipes))

(defn all-menus [] (k/select menus))
