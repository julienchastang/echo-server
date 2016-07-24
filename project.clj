(defproject echo-server "0.1.0-SNAPSHOT"
  :description "Echo server"
  :url "https://github.com/julienchastang/echo-server"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [server-socket "1.0.0"]]
  :main ^:skip-aot echo-server.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
