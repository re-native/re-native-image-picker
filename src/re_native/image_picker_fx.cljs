(ns re-native.image-picker-fx
  (:require [reagent.core :as r]
            [re-native.core :refer [os]]
            [re-native.image-picker :refer [showImagePicker]]
            [clojure.string :as st]
            [re-frame.core :as re]))

(re/reg-fx
 :show-image-picker
 (fn show-image-picker-fx [{:keys [on-success
                                   on-failure]
                            :or {on-failure [:show-image-picker-no-on-failure]
                                 on-success [:show-image-picker-no-on-success]}}]
   (showImagePicker
    (clj->js {:noData true
              :allowsEditing true
              :storageOptions {:skipBackup true
                               :path "images"}})
    (fn launch-image-library-fx-fn [response]
      (let [e (.-error response)]
        (if e
          (re/dispatch (conj on-failure (.-error response)))
          (if (not (or (nil? response) (nil? (.-uri response))))
            (let [uri (if (= os "ios")
                        (st/replace (.-uri response) #"file://" "")
                        (.-path response))]
              (re/dispatch (conj on-success uri))))))))))
