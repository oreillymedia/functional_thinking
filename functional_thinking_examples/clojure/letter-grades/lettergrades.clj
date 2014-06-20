(ns lettergrades)

(defn in [score low high]
  (and (number? score) (<= low score high)))

(defn letter-grade [score]
  (cond
    (in score 90 100) "A"
    (in score 80 90)  "B"
    (in score 70 80)  "C"
    (in score 60 70)  "D"
    (in score 0 60)   "F"
    (re-find #"[ABCDFabcdf]" score) (.toUpperCase score)))



