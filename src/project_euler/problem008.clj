(ns project-euler)

(defn calc-product [lst]
  (reduce * (map #(- (int %) 48) lst)))

(defn contains-0? [lst]
  (some #(= \0 %) lst))

;; Elapsed time: 33.323509 msecs
(defn euler-008 []
  (reduce max (map calc-product 
                   (filter #(not (contains-0? %))
                           (partition 5 1 (remove #(= \newline %) (seq (slurp "res/problem008.txt"))))))))