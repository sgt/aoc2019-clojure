(ns aof2019.day3-test
  (:require [clojure.test :refer :all])
  (:require [aof2019.day3 :refer :all]))

(deftest parsing-input-test
  (testing "parsing input"
    (is (= (parse-input-line "R1,D2,U3")
           [(->Instruction \R 1) (->Instruction \D 2) (->Instruction \U 3)]))))

(deftest parse-wire-test
  (testing "parsing a wire"
    (is (= (parse-wire [(->Instruction \U 2) (->Instruction \R 2)])
           [[0 0] [0 1] [0 2] [1 2] [2 2]]))))

(deftest problem-test
  (testing "parts 1 and 2"
    (let [input1 (parse-input-line "R75,D30,R83,U83,L12,D49,R71,U7,L72")
          input2 (parse-input-line "U62,R66,U55,R34,D71,R55,D58,R83")]
      (is (= (part-one [input1 input2]) 159))
      (is (= (part-two [input1 input2]) 610)))
    (let [input1 (parse-input-line "R98,U47,R26,D63,R33,U87,L62,D20,R33,U53,R51")
          input2 (parse-input-line "U98,R91,D20,R16,D67,R40,U7,R15,U6,R7")]
      (is (= (part-one [input1 input2]) 135))
      (is (= (part-two [input1 input2]) 410)))))
