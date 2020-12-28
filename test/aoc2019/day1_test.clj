(ns aoc2019.day1-test
  (:require [clojure.test :refer :all])
  (:require [aoc2019.day1 :refer :all]))

(deftest calc-fuel-test
  (testing "calc-fuel"
    (is (= (calc-fuel 1) 0))))

(deftest calc-complete-fuel-test
  (testing "calc-complete-fuel"
    (is (= (calc-complete-fuel 14) 2))
    (is (= (calc-complete-fuel 1969) 966))
    (is (= (calc-complete-fuel 100756) 50346))))
