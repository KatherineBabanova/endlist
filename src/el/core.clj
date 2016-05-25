(ns el.core
  (:require
    [clojure.tools.nrepl.server :as nrepl-server]
    [cider.nrepl :refer (cider-nrepl-handler)])
  (:gen-class))

(defonce nrepl (atom nil))

(defn -main "Application entry point" [& args]
  (println "here")
  (reset! nrepl (nrepl-server/start-server :bind "10.0.0.10" :port 2525 :handler cider-nrepl-handler)))
