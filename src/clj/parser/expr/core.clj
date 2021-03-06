(ns parser.expr.core
  (:import [org.antlr.v4.runtime ANTLRInputStream CommonTokenStream]
           [java.io FileInputStream]
           [grammar.expr ExprLexer ExprParser] ))

(use 'debux.core)

;;; 4.1 Matching an Arithmetic Expression Language

(defn calc [[input-file]]
  (dbg input-file)
  (let [is (if input-file
             (FileInputStream. input-file)
             System/in)
        parser (-> (ANTLRInputStream. is)
                   (ExprLexer.)
                   (CommonTokenStream.)
                   (ExprParser.))
        tree (.prog parser)]
    (println (.toStringTree tree parser)) ))

