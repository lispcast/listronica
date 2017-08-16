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
                "</div>"
                "<form method=\"POST\" action=\"/items\">"
                "<input type=\"text\" name=\"name\" placeholder=\"name\">"
                "<input type=\"text\" name=\"description\" placeholder=\"description\">"
                "<input type=\"submit\">"
                "</form>"
                "</body></html>")}))

(defn handle-create-item [req]
  (let [name (get-in req [:params "name"])
        description (get-in req [:params "description"])
        db (:webdev/db req)
        item-id (create-item db name description)]
    {:status 302
     :headers {"Location" "/items"}
     :body ""}))
