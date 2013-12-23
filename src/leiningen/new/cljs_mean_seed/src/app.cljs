(ns {{name}}
  (:require [cljs.nodejs :as node]))

(def express (node/require "express"))
(def app (express))

(defn index [req res]
  (.render res "index"))

(defn partials [req res]
  (let [name (-> req/params.name)]
    (.render res (str "partials/" name))))

(defn -main [& args]
  (doto app
    (.set :port (or (-> node/process.env.PORT) 3000))
    (.set "view engine", "jade")
    (.set "views", (str (node/process.cwd) "/views"))
    (.use (. express (logger "dev")))
    (.use (. express (bodyParser)))
    (.use (. express (methodOverride)))

    ;; Routes
    (.get "/" #(index %1 %2))
    (.get "/partials/:name", #(partials %1 %2))
    (.listen (.get app :port))
    (println (str "Express server started on port: " (.get app :port)))))

(set! *main-cli-fn* -main)