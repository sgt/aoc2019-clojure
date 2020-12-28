(ns aoc2019.core
  (:gen-class)
  (:require [aoc2019.day1]
            [aoc2019.day2]
            [aoc2019.day3]
            [aoc2019.day4]))

(defn- run [nspace func & args]
  {} (apply (resolve (symbol nspace func)) args))

(defn -main [& args]
  (if (empty? args)
    (println "day required")
    (let [nspace (str "aoc2019.day" (first args))
          input (run nspace "read-input")]
      (println "Part one: " (run nspace "part-one" input))
      (println "Part two: " (run nspace "part-two" input)))))
