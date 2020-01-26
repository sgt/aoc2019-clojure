(ns aof2019.intcode)

(defn- update-prog
  "update "
  [prog op arg1-pos]
  (let [[arg1-pos arg2-pos result-pos] (subvec prog arg1-pos (+ arg1-pos 4))
        [arg1 arg2] (map prog [arg1-pos arg2-pos])
        result (op arg1 arg2)]
    (assoc prog result-pos result)))

(defn intcode
  ([prog] (intcode prog 0))
  ([prog ip]
   ;; if 99 then prog, otherwise declare vars and do assoc with calculated result
   (case (nth prog ip)
     1 (intcode (update-prog prog + (inc ip)) (+ ip 4))
     2 (intcode (update-prog prog * (inc ip)) (+ ip 4))
     99 prog
     (throw (RuntimeException. "unknown opcode")))))
