package dependencies

object Dependencies {

    val values  = listOf(
        "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}",
        "androidx.core:core-ktx:${Versions.core_ktx}",
        "com.google.firebase:firebase-analytics-ktx:${Versions.firebase_analytics}",
        "com.google.firebase:firebase-firestore:${Versions.firebase_firestore}",
        "com.google.firebase:firebase-storage:${Versions.firebase_storage}",
        "com.google.firebase:firebase-crashlytics:${Versions.crashlytics}",
        "com.squareup.retrofit2:retrofit:${Versions.retrofit}",
        "com.google.dagger:dagger:${Versions.dagger}",
        "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}",
        "androidx.navigation:navigation-ui-ktx:${Versions.navigation}",
        "com.google.android.gms:play-services-maps:${Versions.maps}",
        "com.google.maps.android:maps-utils-ktx:${Versions.maps_ktx}",
        "com.github.bumptech.glide:glide:${Versions.glide}",
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}",
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}",
        "androidx.legacy:legacy-support-v4:${Versions.legacy}",
        "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle_version}",
        "com.github.jkwiecien:EasyImage:${Versions.easyimage_version}",
        "org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.kotlin_coroutines_play_services}",
        "id.zelory:compressor:${Versions.image_compressor_version}",
        "com.airbnb.android:lottie:${Versions.lottie_version}"
    )
}