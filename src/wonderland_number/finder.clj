(ns wonderland-number.finder)

(def ^:private six-digts-nums
  (range 100000 1000000))

(defn- digits [num]
  (set (str num)))

(defn- same-digits? [num1 num2]
  (= (digits num1) (digits num2)))

(defn- multiples [num]
  (map #(* num %) [2 3 4 5 6]))

(defn- wonder? [num]
  (every? (partial same-digits? num) (multiples num)))

(defn find-wonderland-number []
  (first (filter wonder? six-digts-nums)))
