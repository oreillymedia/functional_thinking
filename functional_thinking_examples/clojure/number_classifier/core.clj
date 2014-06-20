(ns number-classifier.core)

; BEGIN number_classifier_clojure
(defn is-factor? [factor number]   ;<1>
  (zero? (rem number factor)))     ;<2>

(defn factors [number]             ;<3>
  (filter #(is-factor? % number) (range 1 (inc number))))

(defn aliquot-sum [number]         ;<4>
  (- (reduce + (factors number)) number))

(defn perfect? [number]
  (= number (aliquot-sum number)))

(defn abundant? [number]
  (< number (aliquot-sum number)))

(defn deficient? [number]
  (> number (aliquot-sum number)))
; END number_classifier_clojure

; BEGIN clojure-fast-factors
(defn fast-factors [number]
  (let [partial-sum (for [n (range 1 (inc (Math/sqrt number))) :when (is-factor? n number)] n)]
    (set (into partial-sum (map #(/ number %) partial-sum)))))
; END clojure-fast-factors

(defn faliquot-sum [number]
  (- (reduce + (fast-factors number)) number))

(defn fast-perfect? [number]
  (= number (faliquot-sum number)))

; BEGIN clojure_classify
(defn classify [num]
  (let [factors (->> (range 1 (inc num))         ; <1>
                (filter #(zero? (rem num %))))   ; <2>
                sum (reduce + factors)           ; <3>
                aliquot-sum (- sum num)]         ; <4>
    
    (cond                                       ; <5>
     (= aliquot-sum num) :perfect
     (> aliquot-sum num) :abundant
     (< aliquot-sum num) :deficient)))
; END clojure_classify