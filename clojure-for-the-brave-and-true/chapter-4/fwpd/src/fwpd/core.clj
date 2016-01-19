(ns fwpd.core)
(def file-name "suspects.csv")

(slurp file-name)

(def vamp-keys [:name :glitter-index])

(def conversions {:name identity :glitter-index  #(Integer. %) })


(defn convert
  [vamp-key value]
  ((get conversions vamp-key) value))


(defn parse
  [string]
  (map #(clojure.string/split % #",")
       (clojure.string/split string #"\n")))

(defn mapify
  [rows]
  (map (fn [row]
        (reduce (fn [row-map [vamp-key value]]
                   (assoc row-map vamp-key (convert vamp-key value)))
                {}
                (map vector vamp-keys row)))
       rows))


(defn gliter-filter
  [min-gliter-value records]
  (filter #(>= (:glitter-index %) min-gliter-value) records))

(gliter-filter 3 (mapify (parse (slurp file-name))))




