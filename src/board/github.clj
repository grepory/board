(ns board.github
  (:gen-class)
  (:require [tentacles.core :as github]
            [board.config :refer [configure]]))

(def moduleName "github")

;; Store github configuration material in ~/.board/github
(defn initialize
  "Initialize github configuration"
  []
  (configure (moduleName)))
