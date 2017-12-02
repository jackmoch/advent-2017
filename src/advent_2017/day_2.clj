(ns advent-2017.day-2
  (:require [clojure.string :as str]
            [criterium.core :as crit]
            [clojure.math.combinatorics :as combo]))

(defn parser [line]
  (map #(Integer/parseInt %)
       (str/split line
                  #"\t")))

(defn max-min-diff
  [coll]
  (let [max (apply max coll)
        min (apply min coll)]
    (- max
       min)))

(defn valid-quotients
  [coll]
  (filter (fn [[a b]]
            (and (= (mod a b)
                    0)
                 (not= a b)))
          (combo/selections coll
                            2)))

(defn part-1 []
  (apply +
         (map max-min-diff
              (map parser
                   (str/split-lines (slurp "inputs/day2.txt"))))))

(defn part-2 []
  (apply +
         (map (fn [[a b]]
                (/ a b))
              (mapcat valid-quotients
                      (map parser
                           (str/split-lines (slurp "inputs/day2.txt")))))))
