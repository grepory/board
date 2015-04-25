(ns board.config
  (:gen-class)
  (:require [clojure.java.io :as io]))

(def ^{:private true} config-dir
  (clojure.string/join "/" [(System/getenv "HOME") ".board"]))

;; Return a single hashmap defined in a file.
(defn- read-config
  [file-name]
  {:pre  [(.exists (io/file file-name))]
   :post [(map? %)]}
  (-> file-name (slurp) (read-string) (eval)))

;; Return a list of filenames
;; Currently unused, but maybe useful in the future because it was
;; before I rewrote the whole thing.
(defn- files-in-dir
  [directory]
  {:pre  [(.isDirectory (io/file directory))]
   :post [(vector? %)]}
  (vec (for [d (.listFiles (io/file directory))]
         (.getCanonicalPath d))))

(defn config-path
  "Get the path to a config file. Optional argument is a submodule for
  configuration (e.g. \"github\")"
  [submodule]
  (clojure.string/join "/" [config-dir (str submodule ".clj")]))

(defn initialize-config
  "Generate a configuration skeleton"
  [directory]
  (let [dir-f (io/file directory)]
    (if-not (.exists dir-f) (.mkdir dir-f))))

;; FIXME: Needs test.
(defn save-config
  "Write configuration file to a directory"
  [config submodule]
  (spit (config-path submodule) (str config)))

(defn load-config
  "Create/update configuration from config dir"
  [submodule]
  (let [config-file (config-path submodule)]
    (if-not (.exists (io/file config-file)) (initialize-config config-file))
    (read-config config-file)))