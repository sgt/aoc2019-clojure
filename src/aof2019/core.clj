(ns aof2019.core
  (:gen-class)
  (:require [aof2019.day1]
            [aof2019.day2]))

(defn- run [nspace func]
  (apply (resolve (symbol nspace func)) []))

(defn -main [& args]
  (if (empty? args)
    (println "day required")
    (let [nspace (str "aof2019.day" (first args))]
      (println "Part one: " (run nspace "part-one"))
      (println "Part two: " (run nspace "part-two")))))
