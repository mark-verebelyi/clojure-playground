(defproject clojure-playground "0.1.0-SNAPSHOT"
  :description "A web crawler for learning Clojure"
  :url "https://github.com/mark-verebelyi/clojure-playground"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"] [enlive "1.1.5"]]
  :main ^:skip-aot zzz.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
