(defproject {{name}} "0.0.1"
  :description "TODO: Write a good description of this web application built on Nodejs using Express and AngularJS."
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2080"]
                 [org.bodil/cljs-noderepl "0.1.10"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {:builds [{:source-paths ["src" "routes"]
                        :compiler {:target :nodejs
                                   :output-to "app.js"
                                   :optimizations :simple
                                   :pretty-print true}},
                       {:source-paths ["public/js"]
                        :compiler {:target :browser
                                   :output-to "public/js/{{name}}.js"
                                   :optimizations :simple
                                   :pretty-print true}}]}
  :plugins [[lein-cljsbuild "1.0.1-SNAPSHOT"]
            [lein-npm "0.1.0"]]
  :node-dependencies [[express "3.4.6"]
                      [jade "~0.31.2"]
                      [stylus "~0.41"]]
  :main "app.js")

