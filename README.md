# re-native-image-picker

A Clojurescript library for [react-native-image-picker](https://github.com/marcshilling/react-native-image-picker)
Meant for use with reagent and re-frame

Tracking      | Artifact
--------------|---------|
`v0.25.0`     | `[re-native/image-picker "0.0.1-SNAPSHOT"]`

# re-natal

```
npm i react-native-image-picker@v0.25.0 --save
re-natal use-component react-native-image-picker
```

# fx

```clojure
(require [re-native.image-picker-fx])

{:show-image-picker {:on-success [:image-picker-on-success]
                     :on-failure [:image-picker-on-failure]}}
```
