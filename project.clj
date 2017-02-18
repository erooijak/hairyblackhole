(defproject hairyblackhole "1.0.0"
  :description "Calculates the amount of hours of YouTube videos in your Firefox
  bookmarks."
  :url "http://www.wishfulthinking.io"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cheshire "5.7.0"]
                 [clj-time "0.13.0"]
                 [com.rpl/specter "0.13.2"]
                 [com.taoensso/timbre "4.8.0"]
                 [http-kit "2.2.0"]
                 [org.clojure/clojure "1.8.0"]
                 [org.xerial/sqlite-jdbc "3.16.1"]
                 [yesql "0.5.3"]]
  :aot  [hairyblackhole.core]
  :main hairyblackhole.core)
