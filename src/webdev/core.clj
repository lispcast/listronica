(ns webdev.core
  (:require [ring.adapter.jetty :as jetty]))

(defn greet [req]
  (cond
    (= "/" (:uri req))
    {:status 200
     :body "Hello, World! Now with no reload!"
     :headers {}}
    (= "/goodbye" (:uri req))
    {:status 200
     :body "Goodbye, Cruel World!"
     :headers {}}
    :else
    {:status 404
     :body "Page not found."
     :headers {}}))

(defn -main [port]
  (jetty/run-jetty greet {:port (Integer. port)}))

;; -dev-main has moved so dev/webdev/dev.clj
;; please see the note at https://purelyfunctional.tv/web-dev-in-clojure/lets-get-a-server-up-and-running-in-the-cloud/#dev-main
