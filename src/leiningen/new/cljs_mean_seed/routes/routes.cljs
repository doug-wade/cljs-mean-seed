(ns {{name}}.routes)

(defn index [req res]
  (let [json-resp (clj->js {"services" ["lists"]})]
    (. res (json json-resp))))

(defn lists [req res]
  ;; TODO: Returns null
  (let [id (get (get req :params) :id)]
    (. res (json (clj->js {"lists" [id]})))))

