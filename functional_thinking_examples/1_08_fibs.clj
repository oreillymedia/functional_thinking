; Fibonacci numbers pass 1000 at n=17
(first 
  (index-filter #(> % 1000) (fibo)))
-> 17