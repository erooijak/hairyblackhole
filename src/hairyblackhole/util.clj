(ns hairyblackhole.util
  (:require [clojure.string :as str])
  (:import [org.joda.time Period]) )

(defn expand-home [s]
  (if (.startsWith s "~")
    (str/replace-first s "~" (System/getProperty "user.home"))
    s))

(defn to-seconds
  "Transforms iso duration into seconds."
  [iso-duration]
  (/ (.. (Period/parse iso-duration)
         toStandardDuration
         getMillis)
     1000))
