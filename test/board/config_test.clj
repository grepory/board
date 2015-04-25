(ns board.config-test
  (:use [midje.sweet :refer :all])
  (:require [board.config :as c]
            [clojure.java.io :as io]))

(def settings-file (.getPath (io/resource "test/config/settings.clj")))
(def settings-map {:a 1, :b 2})

(facts "about config-path"
  (fact "yields an absolute path to a configuration file"
    (#'c/config-path "common")
    => (str (System/getenv "HOME") "/.board/common.clj")))

(facts "about files-in-dir"
  (fact "it returns a vector of files"
    (->> (#'c/files-in-dir (.getPath (io/resource "test/config/")))
      (map #(clojure.string/split % #"/"))
      (map last)) => ["settings.clj" "settings1.clj" "settings2.clj"]))

(facts "about read-config"
  (fact "returns a deserialized hashmap"
    (#'c/read-config settings-file) => settings-map))

(facts "about configure"
  (fact "it reads a configuration file"
    (c/load-config "settings") => settings-map
    (provided
      (#'c/config-path "settings")
      => (.getPath (io/resource "test/config/settings.clj")))))