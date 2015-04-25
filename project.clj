(defproject board "0.1.0-SNAPSHOT"
  :description "Common onboarding tasks in the internet of SaaSes."
  :url "https://github.com/grepory/board"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [tentacles "0.3.0"]]
  :main ^:skip-aot board.core
  :target-path "target/%s"
  :profiles {
             :uberjar {:aot :all}
             :dev     {:dependencies [[midje "1.6.3"]]}}
  :resource-paths ["resources", "test/resources"])
