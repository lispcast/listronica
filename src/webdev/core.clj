(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]))

(defn greet [req]
  (if (= "/" (:uri req))
    {:status 200
     :body "Hello, World!"
     :headers {}}
    {:status 404
     :body "Page not found."
     :headers {}}))

(defn -main [port]
  (jetty/run-jetty greet                 {:port (Integer. port)}))

(defn -dev-main [port]
  (jetty/run-jetty (wrap-reload #'greet) {:port (Integer. port)}))
