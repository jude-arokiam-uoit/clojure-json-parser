(ns csci3055u-a3.core
  (:require [cheshire.core :refer :all]))

(defn get-title [course]
  (:title course))

(defn get-grades [course]
  (let [all-students (:students course)]
    (map #(:grade %) all-students)))

(defn get-range [grades]
  (let [lowest-grade (apply min grades)
        highest-grade (apply max grades)]
    (vector lowest-grade highest-grade)))

(defn calc-average [grades]
  (let [num-grades (count grades)
        grade-sum (apply + (vec grades))]
    (/ grade-sum num-grades)))

(defn find-best-student [course grades]
  (let [best-grade (apply max grades)
        all-students (:students course)
        best-students  (filter #(= (:grade %) best-grade) all-students)
        the-best (reduce into {} best-students)]
    (:name the-best)))

(defn main [& args]
  (let [filename (first *command-line-args*)
        string-file (slurp filename)
        parsed-json (parse-string string-file true)
        title (get-title parsed-json)
        grades (get-grades parsed-json)
        grade-range (get-range grades)
        average (calc-average grades)
        best-student (find-best-student parsed-json grades)]
    (do 
      (println title)
      (println (format "Range: %.2f to %.2f" (get grade-range 0) (get grade-range 1)))
      (println (format "Average: %.2f" average))
      (println (str "Best student: " best-student)))))
