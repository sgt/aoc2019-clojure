(ns aof2019.intcode)

(defrecord Machine [prog input output])
(defrecord Opcode [arity func])

(defn op1
  "addition"
  [machine a1 a2 result-pos]
  (update machine :prog #(assoc % result-pos (+ a1 a2))))

(defn op2
  "multiplication"
  [machine a1 a2 result-pos]
  (update machine :prog #(assoc % result-pos (* a1 a2))))

(defn op3
  "store input"
  [machine result-pos]
  (let [cur-input (first (:input machine))]
    (-> machine
        (update :prog #(assoc % result-pos cur-input))
        (update :input rest))))

(defn op4
  "produce output"
  [machine arg1]
  (update machine :output #(conj % arg1)))

(defn decode-opcode [opcode]
  )

(def opcodes {1 (->Opcode 3 op1)
              2 (->Opcode 3 op2)
              3 (->Opcode 1 op3)
              4 (->Opcode 4 op4)})

(defn intcode
  ([prog] (intcode prog 0))
  ([prog input] (intcode prog input 0))
  ([prog input ip]
   (loop [prog prog
          ip ip
          input input
          output []]
     (case (nth prog ip)
       1 (recur (opcode-two-args prog + (inc ip)) (+ ip 4) input output)
       2 (recur (opcode-two-args prog * (inc ip)) (+ ip 4) input output)
       3 (recur (store-input (first input) prog (inc ip)) (+ ip 2) (rest input) output)
       4 (recur prog (+ ip 2) input (conj output (produce-output prog (inc ip))))
       99 {:prog prog :output output}))))
