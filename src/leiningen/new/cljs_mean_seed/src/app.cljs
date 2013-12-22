(ns {{name}}.core
  (:require [cljs.nodejs :as node]
            [{{name}}.routes :as routes]))
 
(def express (node/require "express"))
(def routes (node/require "routes"))

(def app (express))
 
(defn -main [& args]
  (doto app
    (.set 'port' (or (-> node/process.env.PORT) "3000"))
    (.set 'views', (str __dirname '/views'))
    (.set 'view engine', 'jade')
    (.use (. express (logger "dev")))
    (.use (. express (bodyParser)))
    (.use (. express (methodOverride)))
    (.use (. app router))

    (.get "/" #(routes/index %1 %2))
    (.get "/lists" #(routes/lists %1 %2))
    (.get "*", #(routes/index %1 %2))
    (.listen (or (-> node/process.env.PORT) 3000)))
  (println (str "Express server started on port: " (.get app port)))
 
(set! *main-cli-fn* -main)
