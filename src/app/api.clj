(ns app.api
  (:require [castra.core :refer [defrpc]])
  (:require [app.db :refer [dbspec get-ws-mdls get-all-ws-from-env env-to-sql-hostname]]))

(defrpc get-state []
  (let [num (rand-int 100)]
    (prn "get-state")
    (prn num)
    {:random num}))

; (defrpc get-ws-mdl []
;   (let [num (rand-int 1000)]
;         ; mydb (assoc dbspec :host "ec2us-mysql1-1-gaga.anaplan.com")]
;         ; data (get-ws-mdls mydb ["Finance" "Workflow POC"])]
;     (prn "get-ws-mdl")
;     ; (prn mydb)
;     ; (prn data)
;     {:random num}))

(defrpc exclaim [ws]
  (let [num (rand-int 1000)
        mydb (assoc dbspec :host "ec2us-mysql1-1-gaga.anaplan.com")
        data (get-ws-mdls mydb [ws])]
    (prn "exclaim!!")
    ; (prn mydb)
    (prn data)
    data))

(defrpc get-env-list []
  (let [envs ["gaga" "nurding" "kesha" "qa2" "gaga" "nurding" "kesha" "qa2" "gaga" "nurding" "kesha" "qa2"]]
    (prn envs)
    envs))


(defrpc get-ws-from-env [env]
  (let [num (rand-int 1000)
        sql-server (env-to-sql-hostname env)
        data (get-all-ws-from-env sql-server)]
    ; (prn data)
    data))
