(ns webdev.item.handler
  (:require [webdev.item.model :refer [create-item
                                       read-items
                                       update-item
                                       delete-item]]))

(defn handle-index-items [req]
  (let [db (:webdev/db req)
        items (read-items db)]
    {:status 200
     :headers {}
     :body (str "<html><head></head><body><div>"
                (mapv :name items)
                "</div></body></html>")}))
