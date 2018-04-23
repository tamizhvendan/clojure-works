(/ 22 7)
(/ 22.0 7)

(quot 22 7)
(rem 22 7)

(+ 0.00001 0.0009M)

(even? 11)

[1 2 3]

(quote (1 2 3))

'(1 2 3)

#{ 1 2}

{"Lisp" "McGrathy" "Clojure" "Rich"}
{"Lisp" "McGrathy","Clojure" "Rich"}
{:lisp "McGrathy" :clojure "Rich"}

(defrecord Book [title author])
(->Book "Programming Clj" "Stuart")

(str \h \return \i)

(true? true)
(true? false)
(true? "hello")
(true? 0)

(symbol? 'hello)

(defn 
  greeting 
  "Greet user's name with Hello
    uses 'world' if the name not provide"
  ([name] (str "Hello, " name))
  ([] (greeting "world")))

(greeting "Tamizh")
(greeting)

(defn div-by-three? [x] (zero? (rem x 3)))

(filter div-by-three? '(4 5 6 9))

(filter (fn [x] (zero? (rem x 3))) '(4 5 6 9))

(filter #(zero? (rem %1 3)) '(3 4 5 6 9))

(require '[clojure.string :as str])
(defn indexable-words [text]
  (let [indexable-word? #(> (count %1) 2)]
    (filter indexable-word? (str/split text #"\W+"))))

(indexable-words "A tale of two friends")

(defn make-adder [x] #(+ x %1))

((make-adder 3) 5)
((make-adder 2) 5)

(defn square-number [bottom left size]
  (let [top (+ bottom size) 
        right (+ left size)]
    [[bottom left] [bottom right] [top left] [top right]]))

(square-number 0 0 50)

(defn greet-author [book]
  (println (:author book)))


(greet-author {:author "Tam" :title "F# Applied"})

(require '[clojure.string :as str])
(str/join " " (str/split "Hello,World" #","))