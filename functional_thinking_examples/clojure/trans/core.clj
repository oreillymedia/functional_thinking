(ns trans.core
  (:require [clojure.string :as s]))

; BEGIN clj_process 
(defn process [list-of-emps]
  (reduce str (interpose "," 
    (map s/capitalize (filter #(< 1 (count %)) list-of-emps)))))
; END clj_process

; BEGIN clj_process_thread
(defn process2 [list-of-emps]
  (->> list-of-emps
       (filter #(< 1 (count %)))
       (map s/capitalize)
       (interpose ",")
       (reduce str)))
; END clj_process_thread
       
	       
	    

		


