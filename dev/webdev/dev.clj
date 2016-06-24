(ns webdev.dev
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [webdev.core :as core]))

(defn -main [port]
  (jetty/run-jetty (wrap-reload #'core/greet) {:port (Integer. port)}))
