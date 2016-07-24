(ns echo-server.core
  (:import 
   [java.io BufferedReader InputStreamReader OutputStreamWriter])
  (:gen-class)
  (:require 
   [server.socket :as ss]))

(def port
  (if *command-line-args*
    (int (first *command-line-args*))
    8888))

(defn echo-server [in out]
 	(binding [*in* (BufferedReader. (InputStreamReader. in))
            *out* (OutputStreamWriter. out)]
 		(loop []
 			(println (read-line))
 			(recur))))
 
(defn -main [& args]
  (ss/create-server port echo-server))

