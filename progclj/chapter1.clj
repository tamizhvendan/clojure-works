(def visitors (atom #{}))

(defn hello [name]
  (swap! visitors conj name)
  (str "Hello, " name))

(hello "tamizh")

(hello "clojure")

(hello "atom & set")

(defn greeter [greet name]
  (str greet name))

; @visitors

; (doc str)
; (find-doc str)

; (require '[clojure.repl :refer [source]])
; ​ 	(source identity)

; (instance? java.util.Collection [1 2 3])