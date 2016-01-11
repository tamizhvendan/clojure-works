(str "Clojure " "is " "just " "awesome")

(vector :a :b :c)

(list 1 2 3)

(hash-map :a 1 :b 2 :c 3)

(hash-set :a :a :b :c)

(defn add100
  "A function to add 100 to the input"
  [x]
  (+ x 100))

(add100 5)

(defn dec-maker
  [dec-by]
  #(- % dec-by))

(def dec9 (dec-maker 9))

(dec9 18)


(defn multi-arity-func
  ([x] (str "Called with one parameter " x))
  ([x y] (str "Called with two parameters " x " " y))
  ([x y & xs] (str "Called with multiple parameters " x " " y " " (clojure.string/join " " xs))))

(multi-arity-func 10)
(multi-arity-func 10 5)
(multi-arity-func 10 5 8 2 3 1)

(defn full-name
  [{first-name :first-name last-name :last-name}]
  (str first-name "," last-name))

(full-name {:first-name "John" :last-name "Smith"})




