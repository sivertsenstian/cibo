(defproject cibo "0.1.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [reagent "0.6.0"]
                 [re-frame "0.9.2"]
                 [secretary "1.2.3"]
                 [compojure "1.5.0"]
                 [yogthos/config "0.8"]
                 [cljs-ajax "0.5.8"]
                 [ring "1.4.0"]
                 [ring-middleware-format "0.7.2"]
                 [korma "0.4.3"]
                 [org.xerial/sqlite-jdbc "3.16.1"]]

  :plugins [[lein-cljsbuild "1.1.4"]]

  :min-lein-version "2.5.3"

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :figwheel {:css-dirs ["resources/public/css"]
             :ring-handler cibo.api.handler/reloadable-handler}

  :profiles
  {:dev
   {:dependencies [[binaryage/devtools "0.9.2"]]
    :plugins      [[lein-figwheel "0.5.9"]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src"]
     :figwheel     {:on-jsload "cibo.client.main/mount-root"}
     :compiler     {:main                 cibo.client.main
                    :output-to            "resources/public/js/compiled/cibo.js"
                    :output-dir           "resources/public/js/compiled/out"
                    :asset-path           "js/compiled/out"
                    :source-map-timestamp true
                    :preloads             [devtools.preload]
                    :external-config      {:devtools/config {:features-to-install :all}}}}

    {:id           "min"
     :source-paths ["src"]
     :jar true
     :compiler     {:main            cibo.client.main
                    :output-to       "resources/public/js/compiled/cibo.js"
                    :optimizations   :advanced
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    false}}]}

  :main cibo.api.server

  :aot [cibo.api.server]

  :uberjar-name "cibo.jar"

  :prep-tasks [["cljsbuild" "once" "min"] "compile"])
