(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn greet [req]
  {:status 200
   :body "Hello, World!"
   :headers {}})

(defroutes app
  (GET "/" [] greet)
  (not-found "Page not found."))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))

;; -dev-main has moved to dev/webdev/dev.clj
;; please see the note at https://purelyfunctional.tv/web-dev-in-clojure/lets-get-a-server-up-and-running-in-the-cloud/#dev-main
