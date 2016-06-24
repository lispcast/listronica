(defproject webdev "0.1.0-SNAPSHOT"
  :description "TODO List app created for LispCast Web Development in Clojure."
  :url "https://purelyfunctional.tv/web-dev-in-clojure"
  :license {:name "CC0 1.0 Universal (CC0 1.0) Public Domain Dedication"
            :url "http://creativecommons.org/publicdomain/zero/1.0/"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring "1.5.0"]
                 [compojure "1.5.1"]]

  :main webdev.core

  :profiles {:dev
             {:source-paths ["src" "dev"]
              :main webdev.dev}})
