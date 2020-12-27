(ns aof2019.day3
  (:require [clojure.string :as str]
            [clojure.set :as s]
            [clojure.java.io :as io]))

(defrecord Instruction [dir dist])

(defn- parse-instruction [s]
  (let [[dir & dist-chars] s
        dist (Integer/parseInt (str/join dist-chars))]
    (->Instruction dir dist)))

(defn- cells-for-section [{dir :dir dist :dist} [x y]]
  (case dir
    \U (for [cy (range (inc y) (+ y dist 1))] [x cy])
    \D (for [cy (range (dec y) (- y dist 1) -1)] [x cy])
    \L (for [cx (range (dec x) (- x dist 1) -1)] [cx y])
    \R (for [cx (range (inc x) (+ x dist 1))] [cx y])
    (throw (RuntimeException. (str "unknown direction '" dir "'")))))

(defn parse-wire [instructions]
  (loop [instructions instructions
         parsed [[0 0]]
         pos [0 0]]
    (if (empty? instructions)
      parsed
      (let [[cur-instruction & rest-instructions] instructions
            cells (cells-for-section cur-instruction pos)]
        (recur rest-instructions (apply conj parsed cells) (last cells))))))

(defn parse-input-line [line]
  (map parse-instruction (str/split line #",")))

(defn read-input []
  (with-open [rdr (io/reader (io/resource "3.txt"))]
    (->> (line-seq rdr)
         (map parse-input-line)
         (vec))))

(defn manhattan-distance [[x y]]
  (+ (Math/abs ^int x) (Math/abs ^int y)))

(defn find-closest-intersection [wires]
  (->> (map set wires)
       (apply s/intersection)
       (map manhattan-distance)
       (filter pos?)
       (apply min)))

(defn find-shortest-path [wires]
  (let [intersections (apply s/intersection (map set wires))
        path-lengths (for [i intersections] [(.indexOf (first wires) i) (.indexOf (second wires) i)])
        total-lengths (map #(reduce + %) path-lengths)]
    (apply min (filter pos? total-lengths))))

(defn part-one [input]
  (find-closest-intersection (map parse-wire input)))

(defn part-two [input] 0
  (find-shortest-path (map parse-wire input)))
