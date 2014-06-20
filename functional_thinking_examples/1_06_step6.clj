// Lispify
(defn index-filter [pred coll]           
  (when pred                     <1>
    (for [[index element] (indexed coll) :when (pred element)] index))) <2>