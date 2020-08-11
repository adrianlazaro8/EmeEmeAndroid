package dependencies

object AndroidTestDependencies {
    val junit_androidx = "androidx.test.ext:junit:${Versions.junit_androidx}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso_core}"
    val instrumentation_runner = "androidx.test.runner.AndroidJUnitRunner"
    val navigation = "androidx.navigation:navigation-testing:${Versions.navigation}"
}