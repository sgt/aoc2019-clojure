(ns aof2019.common-test
  (:require [clojure.test :refer :all])
  (:require [aof2019.common :refer :all]
            [clojure.java.io :as io]))

(deftest read-ints-from-file-test
  (testing "reading ints"
    (let [ints (read-ints-from-file (io/resource "1.txt"))]
      (is (= 100 (count ints)))
      (is (= 88062 (first ints))))))

(deftest read-intcode-prog-from-file-test
  (testing "reading intcode program"
    (let [prog (read-intcode-prog-from-file (io/resource "2.txt"))]
      (is (= 145 (count prog)))
      (is (= 3 (prog 3))))))
