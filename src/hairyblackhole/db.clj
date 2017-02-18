(ns hairyblackhole.db
  "Repository for SQLite bookmarks file of Firefox."
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [hairyblackhole.util :refer [expand-home]]
            [yesql.core :refer [defqueries]]))

(def ^:private profiles
  (io/file (expand-home "~/Library/Application Support/Firefox/Profiles/")))

(def ^:private default-profile-name
  (->> profiles
       file-seq
       (filter #(.contains (.getName %) "default"))
       first
       .getName))

(def ^:private places-db-path
  (str/join "/" [(.getPath profiles) default-profile-name "places.sqlite"]))

(def ^:private db-spec
  {:classname   "org.sqlite.JDBC"
   :subprotocol "sqlite"
   :subname     places-db-path})

(defqueries "queries/videos.sql"
  {:connection db-spec})
