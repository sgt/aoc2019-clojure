(ns aof2019.day2
  (:require [clojure.java.io :as io]
            [aof2019.common :as c]
            [aof2019.intcode :as i]))

(defn- search-inputs [input-prog desired-output]
  (for [noun (range 99)
        verb (range 99)
        :when (let [prog (assoc input-prog 1 noun 2 verb)
                    output (first (i/intcode prog))]
                (= desired-output output))]
    [noun verb]))

(defn part-one []
  (let [orig-prog (c/read-intcode-prog-from-file (io/resource "2.txt"))
        prog (assoc orig-prog 1 12 2 2)]
    (first (i/intcode prog))))

(defn part-two []
  (let [orig-prog (c/read-intcode-prog-from-file (io/resource "2.txt"))
        [noun verb] (first (search-inputs orig-prog 19690720))]
    (+ (* 100 noun) verb)))
