(ns aoc2019.day1
  (:require [clojure.java.io :as io]))

(defn calc-fuel [mass]
  (max 0 (- (quot mass 3) 2)))

(defn calc-complete-fuel [mass]
  (->> (calc-fuel mass)
       (iterate calc-fuel)
       (take-while pos?)
       (reduce +)))

(defn read-input []
  (with-open [rdr (io/reader (io/resource "1.txt"))]
    (->> (line-seq rdr)
         (map #(Integer/parseInt %))
         (vec))))

(defn part-one [input]
  (->> input
       (map calc-fuel)
       (reduce +)))

(defn part-two [input]
  (->> input
       (map calc-complete-fuel)
       (reduce +)))
