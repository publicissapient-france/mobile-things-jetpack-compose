# Mobile Things - Step 0

# Requirements
Use the latest Android Studio **Canary**

# Goal
Setup Jetpack Compose ;-) and get a first preview.
If you clone this repo, setup is done you can test the preview directly!

# Hints

project build.gradle
```
    ext.compose_version = '0.1.0-dev03'
```

app module build.gradle
```
buildFeatures {
        // Enables Jetpack Compose for this module
        compose true
    }
```

app module build.gradle
```
    implementation("androidx.compose:compose-runtime:$compose_version")
    implementation("androidx.ui:ui-framework:$compose_version")
    implementation("androidx.ui:ui-layout:$compose_version")
    implementation("androidx.ui:ui-material:$compose_version")
    implementation("androidx.ui:ui-foundation:$compose_version")
    implementation("androidx.ui:ui-animation:$compose_version")
    implementation "androidx.ui:ui-tooling:$compose_version"
```

[Next](./step_1.md)