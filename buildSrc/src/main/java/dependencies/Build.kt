package dependencies

object Build {
    val build_tools = "com.android.tools.build:gradle:${Versions.android_gradle}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    val google_services = "com.google.gms:google-services:${Versions.google_services}"
}