(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [not-found]]))

(defn greet [req]
  {:status 200
   :body "Hello, World!"
   :headers {}})

(defn goodbye [req]
  {:status 200
   :body "Goodbye, Cruel World!"
   :headers {}})

(defn about [req]
  {:status 200
   :body "My name is Eric Normand and I created this site! Isn't it lovely?"
   :headers {}})

(defn request [req]
  {:status 200
   :body (pr-str req)
   :headers {}})

(defroutes app
  (GET "/" [] greet)
  (GET "/goodbye" [] goodbye)

  (GET "/about" [] about)
  (GET "/request" [] request)
  (not-found "Page not found."))

(defn -main [port]
  (jetty/run-jetty app {:port (Integer. port)}))

;; -dev-main has moved to dev/webdev/dev.clj
;; please see the note at https://purelyfunctional.tv/web-dev-in-clojure/lets-get-a-server-up-and-running-in-the-cloud/#dev-main
