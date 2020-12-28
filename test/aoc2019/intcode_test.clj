(ns aoc2019.intcode-test
  (:require [clojure.test :refer :all])
  (:require [aoc2019.intcode :refer [intcode]]))

(deftest intcode-test
  (testing "intcode vm"
    (is (= (intcode [1 0 0 0 99]) [2 0 0 0 99]))
    (is (= (intcode [2 3 0 3 99]) [2 3 0 6 99]))
    (is (= (intcode [2 4 4 5 99 0]) [2 4 4 5 99 9801]))
    (is (= (intcode [1 1 1 4 99 5 6 0 99]) [30 1 1 4 2 5 6 0 99]))
    (is (= (intcode [1 9 10 3 2 3 11 0 99 30 40 50]) [3500 9 10 70 2 3 11 0 99 30 40 50]))))
