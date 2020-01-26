(ns aof2019.common
  (:require [clojure.java.io :as io]
            [clojure.string :as s]))

(defn read-ints-from-file [filename]
  (with-open [rdr (io/reader filename)]
    (->> (line-seq rdr)
         (map #(Integer/parseInt %))
         (vec))))

(defn read-intcode-prog-from-file [filename]
  (with-open [rdr (io/reader filename)]
    (let [line (first (line-seq rdr))
          num-strings (s/split line #",")]
      (vec (map #(Integer/parseInt %) num-strings)))))
