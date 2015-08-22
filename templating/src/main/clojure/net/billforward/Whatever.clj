(ns net.billforward.Whatever
	(:gen-class
		:methods [#^{:static true} [hello [net.billforward.Invoicey] String]])
	(:use [hiccup.core])
	)
(println "Hello World 1")
(defn -hello [invoice] (html [:span {:class "foo"} (.getId invoice)]))

(defn -main [] (println "Hello from Clojure -main." ))