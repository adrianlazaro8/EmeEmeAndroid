package dependencies

import sun.misc.Version

object Dependencies {
    val kotlin_standard_library = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    val kotlin_core = "androidx.core:core-ktx:${Versions.core_ktx}"
    val firebase_analytics = "com.google.firebase:firebase-analytics:${Versions.firebase_analytics}"
    val firebase_firestore = "com.google.firebase:firebase-firestore:${Versions.firebase_firestore}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val maps = "com.google.maps.android:android-maps-utils:${Versions.maps}"
    val maps_ktx = "com.google.maps.android:maps-utils-ktx:${Versions.maps_ktx}"
}