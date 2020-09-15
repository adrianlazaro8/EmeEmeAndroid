package dependencies

object Dependencies {
    val kotlin_standard_library = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    val kotlin_core = "androidx.core:core-ktx:${Versions.core_ktx}"
    val firebase_analytics = "com.google.firebase:firebase-analytics-ktx:${Versions.firebase_analytics}"
    val firebase_firestore = "com.google.firebase:firebase-firestore:${Versions.firebase_firestore}"
    val crashlytics = "com.google.firebase:firebase-crashlytics:${Versions.crashlytics}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val navigation_fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigation_ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"
    val maps_ktx = "com.google.maps.android:maps-utils-ktx:${Versions.maps_ktx}"
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val viewmodels = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"
    val compiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    val lifecycle_extensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}"
}