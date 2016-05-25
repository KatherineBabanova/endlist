(defproject dist/endlist "0.0.1-SNAPSHOT"
  :description "Endlist project"
  :jar-name "endlist.jar"
  :uberjar-name "endlist-uber.jar"
  :url "http://dist.net/el"
  :main el.core
  :aot [el.core]
  :plugins [[lein-libdir "0.1.1"]
            [refactor-nrepl "2.2.0-SNAPSHOT"]
            [cider/cider-nrepl "0.12.0-SNAPSHOT"]
            [lein-figwheel "0.5.0-6"]]
  :license {:name "UNLICENSE" :url "file:///UNLICENSE" }
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/core.async "0.2.374"]
                 [org.clojure/clojurescript "1.7.228"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/java.jdbc "0.4.2"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.slf4j/slf4j-log4j12 "1.7.18"]
                 [com.novemberain/monger "3.0.2"]
                 [net.sourceforge.jtds/jtds "1.3.1"]
                 [clojure-csv/clojure-csv "2.0.2"]
                 [clj-logging-config "1.9.12"]
                 [ring "1.4.0"]
                 [monotony "0.0.6"]
                 [http-kit "2.1.18"]
                 [clout "2.1.2"]
                 [lib-noir "0.9.9"]
                 [compojure "1.4.0"]
                 [hiccup "1.0.5"]
                 [clj-time "0.11.0"]
                 [clj-http "2.1.0"]
                 [cheshire "5.5.0"]
                 [clj-stacktrace "0.2.8"]
                 [javax.mail/mail "1.4.7"]
                 [com.novemberain/pantomime "2.8.0"]
                 [org.clojars.nakkaya/subethasmtp "3.1.7"]
                 [silasdavis/at-at "1.2.0"]
                 [com.taoensso/encore "2.40.2"]
                 [com.taoensso/nippy "2.11.1"]
                 [org.clojure/core.match "0.3.0-alpha4" :exclusions [org.clojure/tools.analyzer.jvm]]
                 [com.draines/postal "1.11.4" :exclusions [commons-codec]]
                 [clojurewerkz/mailer "1.3.0" :exclusions [org.clojure/data.priority-map org.clojure/core.cache]]
                 [com.taoensso/carmine "2.12.2" :exclusions [com.taoensso/encore com.taoensso/timbre]]
                 [com.taoensso/sente "1.8.0" :exclusions [org.clojure/core.async]]
                 [im.chit/cronj "1.4.4" :exclusions [org.clojure/tools.logging]]
                 ;;[prismatic/schema "1.0.5"]
                 ]
  :injections [(let [orig (ns-resolve (doto 'clojure.stacktrace require) 'print-cause-trace)
                     new (ns-resolve (doto 'clj-stacktrace.repl require) 'pst)]
                 (alter-var-root orig (constantly (deref new))))]
  :cljsbuild {:builds [{:id "el"
                        :source-paths ["src/el_js"]
                        :figwheel true
                        :compiler {:main "el.core"
                                   :asset-path "out"
                                   :output-to "resources/public/el.js"
                                   :optimizations :none
                                   :pretty-print false}}]}
  :omit-source true
  :resources-path "resources"
  :jvm-opts ["-Xmx8g"])
