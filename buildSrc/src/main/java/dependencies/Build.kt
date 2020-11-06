package dependencies

object Build {
    val build_tools = "com.android.tools.build:gradle:${Versions.android_gradle}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    val google_services = "com.google.gms:google-services:${Versions.google_services}"
    val google_crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlytics_build}"
    val safe_args = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation_safe_args}"
}