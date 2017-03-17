(ns re-native.image-picker
  (:require [reagent.core :as r]
            [re-frame.core :as re]))

(def react-native-image-picker (js/require "react-native-image-picker"))

(def showImagePicker (-> react-native-image-picker .-showImagePicker))

(assert react-native-image-picker)
(assert showImagePicker)
