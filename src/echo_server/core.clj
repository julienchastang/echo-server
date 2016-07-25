(ns echo-server.core
  (:import 
   [java.io BufferedReader InputStreamReader OutputStreamWriter])
  (:gen-class)
  (:require 
   [server.socket :as ss]))

(defn echo-server [in out]
 	(binding [*in* (BufferedReader. (InputStreamReader. in))
            *out* (OutputStreamWriter. out)]
 		(loop []
 			(println (read-line))
 			(recur))))
 
(defn -main [& args]
  (let [port (if *command-line-args*
               (int (first *command-line-args*))
               8888)]
    (ss/create-server port echo-server)))

