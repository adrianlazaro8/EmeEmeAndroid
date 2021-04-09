package dependencies

object AndroidTestDependencies {

    val values = listOf(
        "androidx.test.ext:junit:${Versions.junit_androidx}",
        "androidx.test.espresso:espresso-core:${Versions.espresso_core}",
        "androidx.navigation:navigation-testing:${Versions.navigation}"

    )

    val instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
}