(ns aof2019.day1
  (:require [clojure.java.io :as io]
            [aof2019.common :as c]))

(defn calc-fuel [mass]
  (let [f (-> (quot mass 3) (- 2))]
    (max 0 f)))

(defn calc-complete-fuel [mass]
  (->> (calc-fuel mass)
       (iterate calc-fuel)
       (take-while pos?)
       (reduce +)))

(defn part-one []
  (->>
    (c/read-ints-from-file (io/resource "1.txt"))
    (map calc-fuel)
    (reduce +)))

(defn part-two []
 (->>
    (c/read-ints-from-file (io/resource "1.txt"))
    (map calc-complete-fuel)
    (reduce +)))
