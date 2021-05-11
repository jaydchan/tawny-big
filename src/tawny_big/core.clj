(ns tawny-big.core
  (:use [tawny.owl])
  (:gen-class))

(defn create-big
  "Create a big ontology"
  [size]

  ;; create ontology
  (defontology example
    :iri "https://www.example.com/"
    :noname true)

  ;; for x in 0..size, create and add class
  (dotimes [x size]
    (owl-class-explicit example (str (+ x 1)) ()))

  ;; println ontology
  (println example)
  (println (owl-class "1"))
  (println example)

  ;; save ontology in .omn and .owl format
  (save-ontology example "example.omn" :omn)
  (save-ontology example "example.owl" :owl))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; create ontology of size=5
  (create-big 5))

