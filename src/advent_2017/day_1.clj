(ns advent-2017.day-1
  (:require [clojure.string :as str]))


(defn part-1 []
  (let [parsed-input (str/split (str/trim-newline
                                  (slurp "inputs/day1.txt"))
                                #"")
        digits       (map #(Integer. %)
                          (conj parsed-input
                                (first parsed-input)))]
    (reduce (fn [acc [a b]]
              (if (= a b)
                (+ a
                   acc)
                acc))
            0
            (partition-all 2 1 digits))))

(defn part-2 []
  (let [digits       (map #(Integer. %)
                          (str/split (str/trim-newline
                                       (slurp "inputs/day1.txt"))
                                     #""))
        halfway-mark (/ (count digits)
                        2)
        first-half   (take halfway-mark
                           digits)
        last-half    (take-last halfway-mark
                                digits)
        tuples       (map (fn [v1 v2]
                            [v1 v2])
                          first-half
                          last-half)]
    (* 2 (reduce (fn [acc [a b]]
                   (if (= a b)
                     (+ a
                        acc)
                     acc))
                 0
                 tuples))))
