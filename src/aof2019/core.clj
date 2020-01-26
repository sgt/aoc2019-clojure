(ns aof2019.core
  (:gen-class)
  (:require [aof2019.day1]
            [aof2019.day2]
            [aof2019.day3]))

(defn- run [nspace func & args]
  (time (apply (resolve (symbol nspace func)) args)))

(defn -main [& args]
  (if (empty? args)
    (println "day required")
    (let [nspace (str "aof2019.day" (first args))
          input (run nspace "read-input")]
      (println "Part one: " (run nspace "part-one" input))
      (println "Part two: " (run nspace "part-two" input)))))
