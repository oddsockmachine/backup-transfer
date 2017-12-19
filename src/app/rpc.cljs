(ns app.rpc
  (:require-macros
    [javelin.core :refer [defc defc=]])
  (:require
   [javelin.core]
   [castra.core :refer [mkremote]]))

(defc stateW {:random nil})
(defc stateR {:random nil})
(defc error nil)
(defc loading [])

(defc= random-number (get stateR :random))
(defc= ws-mdl (get stateW :random))

(def get-state
  (mkremote 'app.api/get-state stateR error loading))

(def get-ws-mdl
  (mkremote 'app.api/get-ws-mdl stateW error loading))


(defn init []
  (get-state)
  (get-ws-mdl)
  (js/setInterval get-ws-mdl 5000)
  (js/setInterval get-state 5000))
