(ns net.billforward.Whatever
	(:gen-class
		:methods [#^{:static true} [hello [] String]]))
(println "Hello World 1")
(defn -hello [] "Hello world")

(defn -main [] (println "Hello from Clojure -main." ))