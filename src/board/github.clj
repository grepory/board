(ns board.github
  (:gen-class)
  (:require [tentacles.oauth :as oauth]
            [board.config :refer [load-config save-config]]))
;
;(def module-name "github")
;(def scopes ["admin:org"])
;
;;(defn basic-authenticated?
;;  "Basic authentication predicate"
;;  [config]
;;  )
;;
;;(defn generate-authorization
;;  "Setup OAuth2 access to Github"
;;  [org-name]
;;  (if basic-authenticated?
;;    (oauth/create-auth )
;;    ())
;;  (oauth/create-auth ))
;;
;;(def config (configure (module-name)))
;;(def auth-token (generate-authorization config/org-name))
