(ns aof2019.day4)

(defn digits [num]
  (loop [num num
         res '()]
    (if (zero? num)
      res
      (recur (quot num 10) (conj res (mod num 10))))))

(defn valid-password? [pwd]
  (let [pairs (partition 2 1 (digits pwd))]
    (and
      (every? (partial apply <=) pairs)
      (some (partial apply =) pairs))))

(defn valid-password-part-two? [pwd]
  (let [pwd-digits (digits pwd)]
    (and
      (every? (partial apply <=) (partition 2 1 pwd-digits))
      (some (partial = 2) (map count (partition-by identity pwd-digits))))))

(defn read-input []
  (range 278384 (inc 824795)))

(defn part-one [input]
  (count (filter valid-password? input)))

(defn part-two [input]
  (count (filter valid-password-part-two? input)))
