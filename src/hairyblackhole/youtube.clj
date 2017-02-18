(ns hairyblackhole.youtube
  (:require [cheshire.core :as json]
            [clojure.string :as str]
            [hairyblackhole.config :refer [settings]]
            [com.rpl.specter :as specter]
            [hairyblackhole.util :refer [to-seconds]]
            [org.httpkit.client :as http]))

(defn- youtube-id
  "Gets YouTube id (stripping off extra query parameters as long as it is time t)"
  [url]
  (-> url (str/split #"v=") last (str/split #"#") first (str/split #"t=") first))

(defn- titles-with-ids
  "Adds Youtube id to the video query result."
  [videos]
  (map
   (fn [{:keys [url] :as video}]
     (assoc video :youtube-id (youtube-id url)))
   videos))

(defn- youtube-api-url
  "Creates URL for the YouTube API."
  [youtube-id]
  (str "https://www.googleapis.com/youtube/v3/videos?id=" youtube-id
       "&key=" (:youtube-api-key settings)
       "&part=contentDetails"))

(defn- youtube-urls
  "Get all YouTube URLs. (Ignoring other information like title for now.)"
  [titles-with-ids]
  (->> titles-with-ids
       (keep :youtube-id)
       (map youtube-api-url)))

(defn- seconds-from-response [{:keys [body status]}]
  "Gets length in seconds of the response of the YouTube API."
  (case status
    200       (->> (json/decode body true)
                   (specter/select [:items specter/ALL :contentDetails :duration])
                   (map to-seconds)
                   (apply +))
    #_default 0))

(defn- total-hours* [youtube-urls]
  (let [promises  (doall (map http/get youtube-urls))
        responses (doall (map deref promises))]
    (int
     (/
      (apply + (map seconds-from-response responses))
      3600))))


;;; PUBLIC

(defn total-hours [videos]
  (-> videos
      titles-with-ids
      youtube-urls
      total-hours*))

(defn titles
  [videos]
  "Get all titles of YouTube videos."
  (->> videos
       titles-with-ids
       (keep :title)))
