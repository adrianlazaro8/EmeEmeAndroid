package dependencies

import sun.misc.Version

object Dependencies {
    val kotlin_standard_library = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
    val kotlin_core = "androidx.core:core-ktx:${Versions.core_ktx}"
    val firebase_analytics = "com.google.firebase:firebase-analytics:${Versions.firebase_analytics}"
    val firebase_firestore = "com.google.firebase:firebase-firestore:${Versions.firebase_firestore}"
}