(ns project-euler)

(defn triangle-number [n]
  (* n (/ (+ n 1) 2)))

(def triangles (map triangle-number (iterate inc 1)))

(defn is-triangle? [n]
  (= n (first (drop-while #(< % n) triangles))))

(defn score [string]
  (reduce + (map #(- (int %) 64) (seq string))))

;; Elapsed time: 38.543659 msecs
(defn euler-042 []
  (count (filter is-triangle? 
                 (map score (re-seq #"\w+" (slurp "res/problem042.txt"))))))