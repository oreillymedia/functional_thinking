(ns primes.core)

(defn factors [n]
  (filter #(zero? (rem n %)) (range 1 (inc n))))

(defn sum-factors [n]
  (reduce + (factors n)))

(defn prime? [n]
  (= (inc n) (sum-factors n)))