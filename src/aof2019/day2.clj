(ns aof2019.day2
  (:require [clojure.java.io :as io]
            [aof2019.intcode :as i]
            [clojure.string :as s]))

(defn- search-inputs [input-prog desired-output]
  (for [noun (range 99)
        verb (range 99)
        :when (let [prog (assoc input-prog 1 noun 2 verb)
                    output (first (i/intcode prog))]
                (= desired-output output))]
    [noun verb]))

(defn read-input []
  (with-open [rdr (io/reader (io/resource "2.txt"))]
    (let [line (first (line-seq rdr))
          num-strings (s/split line #",")]
      (vec (map #(Integer/parseInt %) num-strings)))))

(defn part-one [input]
  (let [prog (assoc input 1 12 2 2)]
    (first (i/intcode prog))))

(defn part-two [input]
  (let [[noun verb] (first (search-inputs input 19690720))]
    (+ (* 100 noun) verb)))
