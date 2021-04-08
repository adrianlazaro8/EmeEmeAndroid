package dependencies

object Kapt {

    val values = listOf(
        "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle_version}",
        "com.google.dagger:dagger-compiler:${Versions.dagger}"
    )
}