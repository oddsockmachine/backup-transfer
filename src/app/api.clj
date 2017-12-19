(ns app.api
  (:require [castra.core :refer [defrpc]])
  (:require [app.db :refer [dbspec get-ws-mdls]]))

(defrpc get-state []
  (let [num (rand-int 100)]
    (prn "get-state")
    (prn num)
    {:random num}))

(defrpc get-ws-mdl []
  (let [num (rand-int 1000)]
        ; mydb (assoc dbspec :host "ec2us-mysql1-1-gaga.anaplan.com")]
        ; data (get-ws-mdls mydb ["Finance" "Workflow POC"])]
    (prn "get-ws-mdl")
    ; (prn mydb)
    ; (prn data)
    {:random num}))

(defrpc exclaim [ws]
  (let [num (rand-int 1000)
        mydb (assoc dbspec :host "ec2us-mysql1-1-gaga.anaplan.com")
        data (get-ws-mdls mydb [ws])]
    (prn "get-ws-mdl!!")
    (prn mydb)
    (prn data)
    data))
