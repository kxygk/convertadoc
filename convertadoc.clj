(ns convertadoc
  "Simple functions to convert Asciidoc `.adoc` files to HTML or whatever"
;;  (:use [clojure.tools.deps.alpha.repl])
  (:import [org.asciidoctor
            Asciidoctor
            OptionsBuilder
            SafeMode]))

(defn
  to-html
  [filestr] ;; "/home/kxygk/Projects/stars/Zeeden2023.adoc"
  (let [input-file (clojure.java.io/file filestr)
        adoctor    (org.asciidoctor.Asciidoctor$Factory/create)
        #_#_
        reveal-option (doto (org.asciidoctor.OptionsBuilder/options)
                        (.backend "revealjs")
                        (.safe org.asciidoctor.SafeMode/UNSAFE)
                        #(.attributes (.attribute (org.asciidoctor.AttributesBuilder/attributes)
                                                 "revealjsdir"
                                                 "../reveal.js")))]
    #_
    (.requireLibrary adoctor
                     (into-array String
                                 ["asciidoctor-revealjs"]))
    (.convertFile adoctor
                  input-file
                  #_
                  reveal-option)))

(defn
  to-reveal
  [filestr] ;; "/home/kxygk/Projects/stars/Zeeden2023.adoc"
  (let [input-file (clojure.java.io/file filestr)
        adoctor    (org.asciidoctor.Asciidoctor$Factory/create)
        reveal-option (doto (org.asciidoctor.OptionsBuilder/options)
                        (.backend "revealjs")
                        (.safe org.asciidoctor.SafeMode/UNSAFE)
                        #(.attributes (.attribute (org.asciidoctor.AttributesBuilder/attributes)
                                                 "revealjsdir"
                                                 "../reveal.js")))]
    (.requireLibrary adoctor
                     (into-array String
                                 ["asciidoctor-revealjs"]))
    (.convertFile adoctor
                  input-file
                  reveal-option)))
