(ns project-euler
  (:use [clojure.contrib.lazy-seqs :only (primes)]))

(def mods (map #(* 2 %) (iterate inc 1)))

(defn is-prime? [n]
  (empty? (filter #(zero? (mod n %))
                  (take-while #(<= % (Math/sqrt n)) primes))))

(defn get-mods [len]
  (let [i (int (/ len 2))]
    (map + [2 4 6 8] (map #(* 8 (dec i) %) [1 1 1 1])))) 

;; Elapsed time: 11654.382655 msecs
(defn euler-058 []
  (loop [nums [3 5 7 9] len 3 pr 3 tot 5]
    (if (< (/ pr tot) 0.1) len
        (let [nn (map + nums (get-mods (+ 2 len)))]
          (recur nn (+ len 2) (+ pr (count (filter is-prime? nn))) (+ tot 4))))))