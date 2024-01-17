(ns elevator.core
  (:require  [clojure.contrib.logging :as log])

  (:gen-class)

  )

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

externalRequest (Outside the lift pressing to enter)
internalRequest (Inside the lift to head to their destination floor)

externlaRequest
-direction, sourcefloor (Floor im on when pressing)
-Eelv checks available requests (if any) & processes the request depending on priority


internalRequest
-destinationFloor

(def currentFloor 0)
(def states [:moving :stopping :idle])
(def currentDirection :up)
(def direction [:up :down])
(def currentState :idle)

(defn externalRequest [sourceFloor direction]
  [req]
  (log/debugf "doAdvance User request : %s" req)

(let [{:keys [sourceFloor direction] :as user-req} (:params req)

      (if (and (> sourceFloor 0) (< currentFloor sourceFloor))
        
        (println (str "Elevator moving " direction " from floor " current-floor " to floor " next-floor)))

      ]))

(defn internalRequest [destinationFloor])

(defn elevator [currentFloor currentDirection currentState])

(defn create-elevator [max-floors]
  (let [state (atom {:current-floor 1
                     :requests (atom #{})
                     :max-floors max-floors})]
    (fn [request-floor]
      (reset! (:requests @state) (conj @(:requests @state) request-floor))
      (loop [current-floor (:current-floor @state)
             requests (vec (sort @(:requests @state)))]
        (if (empty? requests)
          (println "Elevator is idle at floor" current-floor)
          (let [next-floor (first requests)
                direction (if (< current-floor next-floor) :up :down)
                new-requests (vec (remove #{"stop"} requests))]
            (println (str "Elevator moving " direction " from floor " current-floor " to floor " next-floor))
            (Thread/sleep 1000) ;Simulating movement time
            (swap! state assoc :current-floor next-floor
                   :requests (atom new-requests))
            (recur next-floor new-requests)))))))

(def my-elevator (create-elevator 10))
; Creating an elevator that can go up to 10 floors

; Simulating requests to the elevator
(my-elevator 5)
(my-elevator 7)
(my-elevator 3)
(my-elevator 10)
(my-elevator 2)

