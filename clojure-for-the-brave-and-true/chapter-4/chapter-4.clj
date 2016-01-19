;; Clojure - Programming to abstractions

;;;;;;;;;;;;; map ;;;;;;;;;;;;;;;;;

(defn number-to-even-or-odd
  [x]
  (if (even? x)
    "even"
    "odd"))

(map number-to-even-or-odd '(1 2 3 4))

(map number-to-even-or-odd [1 2 3 4])

(map number-to-even-or-odd #{ 1 2 3})

(seq {:a 1 :b 2 :c 3 :d 4})

;; map function calls seq function before applying transformation
(map #(number-to-even-or-odd (second %)) {:a 1 :b 2 :c 3 :d 4})

;; into function transforms seq to given data structure
(= {:a 1 :b 2 :c 3 :d 4} (into {} (seq {:a 1 :b 2 :c 3 :d 4})))
(= [1 2 3] (into [] (seq [1 2 3])))
(= #{1} (into #{} '(1 1)))


(def names ["John" "Jack" "Tom"])
(def ages [23 25 27])
(defn name-and-age
  [name age]
  {:name name :age age})

;; map can take multiple collections
(map name-and-age names ages)


;; getting crazy - passing a collection of functions to map!
(def sum #(reduce + %))
(def mean #(/ (sum %) (float (count %))))
(defn stats
  [numbers]
  (map #(% numbers) [sum count mean]))

(stats [1 2 3])

(def people
  [{:name "John" :age 23}
   {:name "Jack" :age 25}
   {:name "Tom" :age 27}
   {:name "Adam" :age 22}])

(map :name people)


;;;;;;;;;;;;;;;; reduce ;;;;;;;;;;;;;;;;;;

(reduce + [1 2 3])

(reduce str ["Clojure" " is " "awesome"])

;reduce treats inputs as sequance similar to map
(reduce
 #(assoc %1 (first %2) (inc (second %2))) ;; #() -> anonymous function
 {}
 {:max 10 :min 5})



(take 2 (range 5))

(drop 2 (range 10))


(take-while #(< (:age %) 25) people)

(drop-while #(< (:age %) 25) people)


(filter #(< (:age %) 25) people)

(some #(< (:age %) 12) people)

(sort [9 11 8 4 6])

;; sort by age
(sort-by #(:age %) people)


;;;;;;;;;;;;;;; Validating Lazy sequance ;;;;;;;;;;;;;;;;


;; create db from people vector created above
;; { 0 {:name "John" :age 23}
;;   ....
;;   4 {:name "Adam" :age 22}}
(def people-db
  (reduce #(assoc %1 %2 (nth people %2)) {} (range 0 4)))

(type people-db)

(defn get-person-details
  [id]
  (Thread/sleep 1000)
  (get people-db id))


(defn adult?
  [person]
  (> (:age person) 18))

(defn identify
  [f ids]
  (first (filter f
                 (map get-person-details ids))))

(identify adult? [1 2 3])

(take 3 (repeatedly #(rand-int 10)))

(take 2 (repeat "foo"))


(every? empty? [[] {} '() #{}])


(conj {:name "John"} {:age 24})

(conj [0] [:a])

(conj [0] :a)


(str ["hello" " world"])

;; applying arrays as a list of arguments
(apply str ["hello" " world"])


(defn inc1
  [x]
  (+ x 1))

(defn dec1
  [x]
  (- x 1))
(defn mul5
  [x]
  (* x 5))

;; composing n functions into 1
(= ((comp mul5 inc1) 10) (mul5 (inc1 10)))

(identify (complement adult?) [1 2 3])

;; partial application of functions

(def inc1-partial (partial + 1))

(= (inc1 10) (inc1-partial 10))














