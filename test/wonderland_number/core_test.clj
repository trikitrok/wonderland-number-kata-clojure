(ns wonderland-number.core-test
  (:require [midje.sweet :refer :all]
            [wonderland-number.finder :as finder]))

(defn same-digits-as [num]
  (fn [multiple]
    (= (set (str num)) (set (str multiple)))))

(defn digits-number [num]
  (count (str num)))

(facts
  "about Wonderland number"

  (let [wondernum (finder/find-wonderland-number)]
    (fact
      "it has six digits"
      (digits-number wondernum) => 6)

    (fact
      "it contains the same digits that its multiples by 2, 3, 4, 5 and 6"
      (* 2 wondernum) => (same-digits-as wondernum)
      (* 3 wondernum) => (same-digits-as wondernum)
      (* 4 wondernum) => (same-digits-as wondernum)
      (* 5 wondernum) => (same-digits-as wondernum)
      (* 6 wondernum) => (same-digits-as wondernum))))
