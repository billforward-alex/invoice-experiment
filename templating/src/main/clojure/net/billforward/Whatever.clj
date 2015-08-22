(ns net.billforward.Whatever
	(:gen-class
		:methods [#^{:static true} [hello [] String]])
	(:use [hiccup.core]))
(println "Hello World 1")
(defn -hello [] (html [:span {:class "foo"} "bar"]))

(defn -main [] (println "Hello from Clojure -main." ))