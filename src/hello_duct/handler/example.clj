(ns hello-duct.handler.example
  (:require ;; [compojure.core :refer :all]
            [compojure.api.sweet :refer :all]
            [clojure.java.io :as io]
            [integrant.core :as ig]))

(defmethod ig/init-key :hello-duct.handler/example [_ options]
  (api
   {:swagger
    {:ui "/api-docs"
     :spec "/swagger.json"
     :data {:info {:title "sample API"
                   :description "compojure api + duct sample"}
            :tags [{:name "api", :description "sample apis"}]
            :consumes ["application/json"]
            :produces ["application/json"]}}}
   (context "/example" []
      (GET "/" []
        (io/resource "hello_duct/handler/example/example.html"))))
)
