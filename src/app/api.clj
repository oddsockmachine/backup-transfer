(ns app.api
  (:require [castra.core :refer [defrpc]])
  (:require [app.db :refer [get-ws-mdls dbspec]]))

(defrpc get-state []
  (let [num (rand-int 100)]
    (prn "get-state")
    (prn num)
    {:random num}))

(defrpc get-ws-mdl []
  (let [num (rand-int 1000)
        mydb (assoc dbspec :host "")
        data (get-ws-mdls mydb ["Finance" "Workflow POC"])]
    (prn "get-ws-mdl")
    (prn mydb)
    (prn data)
    {:random num}))
