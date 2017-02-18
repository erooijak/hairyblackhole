(ns hairyblackhole.core
  (:require [hairyblackhole.db :refer [videos]]
            [hairyblackhole.youtube :as youtube])
  (:gen-class))

(defn -main [& args]
  (let [vids (videos)]
    (println "Videos: ")
    (doseq [title (youtube/titles vids)]
      (println "-" title))
    (println)
    (->> vids
         youtube/total-hours
         (println "Total hours:"))))
