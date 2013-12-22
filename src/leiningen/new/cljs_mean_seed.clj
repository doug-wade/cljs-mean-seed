(ns leiningen.new.cljs-mean-seed
  (:require [leiningen.new.templates :refer [renderer name-to-path year ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "cljs-mean-seed"))

(defn cljs-mean-seed 
  "Create a new project from the cljs-mean-seed"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year (year)}]
    (main/info "Generating fresh 'lein new' cljs-mean-seed project.")
    (->files data
      [".gitignore" (render "gitignore" data)]
      ["LICENSE" (render "LICENSE" data)]
      ["README.md" (render "README.md" data)]
      ["src/app.cljs" (render "src/app.cljs" data)]
      ["public/js/services.cljs" (render "public/js/services.cljs" data)]
      ["public/js/filters.cljs" (render "public/js/filters.cljs" data)]
      ["public/js/directives.cljs" (render "public/js/directives.cljs" data)]
      ["public/js/controllers.cljs" (render "public/js/controllers.cljs" data)]
      ["public/js/app.cljs" (render "public/js/app.cljs" data)]
      ["public/css/app.styl" (render "public/css/app.styl")]
      ["views/index.jade" (render "views/index.jade")]
      ["views/layout.jade" (render "views/layout.jade")]
      ["views/partials/partial1.jade" (render "views/partials/partial1.jade"  data)]
      ["views/partials/partial2.jade" (render "views/partials/partial2.jade")]
      ["routes/routes.cljs" (render "routes/routes.cljs" data)]
      ["project.clj" (render "project.clj" data)])))