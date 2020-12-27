(ns aof2019.day4-test
  (:require [clojure.test :refer :all])
  (:require [aof2019.day4 :refer :all]))

(deftest digits-test
  (testing "breaking int into digits"
    (is (= (digits 1234) [1 2 3 4]))))

(deftest valid-password?-test
  (testing "is password valid"
    (is (valid-password? 111111))
    (is (valid-password? 122345))
    (is (valid-password? 111123))
    (is (not (valid-password? 135679)))
    (is (not (valid-password? 223450)))
    (is (not (valid-password? 123789)))))

(deftest valid-password-part-two?-test
  (testing "is password part two valid"
    (is (valid-password-part-two? 112233))
    (is (not (valid-password-part-two? 123444)))
    (is (valid-password-part-two? 111122))))
