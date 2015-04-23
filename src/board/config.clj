(ns board.config
  (:gen-class)
  (:require [clojure.java.io :as io]))

(defn configDir
  "Get the path to a configuration directory"
  [& args]
  (clojure.string/join "/" (reduce conj [(System/getenv "HOME") ".board"] args)))

(defn readConfig
  "Read configuration from a given directory"
  [directory]
  ;; Do something here
  )

(defn generateConfig
  "Generate a configuration skeleton"
  [directory]
  (.mkdir (io/file directory)))

(defn configure
  "Create/update configuration from config dir"
  [& [directory]]
  (def dir (configDir directory))
  (if  (.isDirectory (io/file dir))
    (readConfig dir)
    (generateConfig dir)))

