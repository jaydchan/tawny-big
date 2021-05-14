(ns tawny-big.core
  (:use [tawny.owl])
  (:gen-class))

;; why o para?
;; tawny.owl uses prefixes by default
(defn iri-gen-example
  [o iri]
  (tawny.owl/iri iri))

(defn create-big
  "Create a big ontology"
  [size]

  ;; create ontology
  (defontology example
    :iri-gen iri-gen-example
    :noname true)

  ;; for x in 0..size, create and add class
  (dotimes [x size]
    (owl-class-explicit example (str "https://www.example.com/o" (+ x 1)) ()))

  ;; println ontology
  (println example)

  ;; save ontology in .omn and .owl format
  (save-ontology example "example.omn" :omn)
  (save-ontology example "example.owl" :owl))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; create ontology of size=5
  (create-big 5))

