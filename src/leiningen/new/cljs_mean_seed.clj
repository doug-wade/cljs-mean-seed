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
      ;; TODO task: public/js/lib/angular/i18n should all be included
      ;; TODO feature: use bower via Grunt via Lein instead of writing this out by hand
      ["public/js/lib/angular/angular.js" (render "public/js/lib/angular/angular.js")]
      ["public/js/lib/angular/angular.min.js" (render "public/js/lib/angular/angular.min.js")]
      ["public/js/lib/angular/angular-bootstrap.js" (render "public/js/lib/angular/angular-bootstrap.js")]
      ["public/js/lib/angular/angular-bootstrap.min.js" (render "public/js/lib/angular/angular-bootstrap.min.js")]
      ["public/js/lib/angular/angular-cookies.js" (render "public/js/lib/angular/angular-cookies.js")]
      ["public/js/lib/angular/angular-cookies.min.js" (render "public/js/lib/angular/angular-cookies.min.js")]
      ["public/js/lib/angular/angular-resource.js" (render "public/js/lib/angular/angular-resource.js")]
      ["public/js/lib/angular/angular-resource.min.js" (render "public/js/lib/angular/angular-resource.min.js")]
      ["public/js/lib/angular/version.json" (render "public/js/lib/angular/version.json")]
      ["public/js/lib/angular/version.txt" (render "public/js/lib/angular/version.txt")]
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
      ["project.clj" (render "project.clj" data)])))