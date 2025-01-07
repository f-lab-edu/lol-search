plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sun5066.source"
}

dependencies {
    implementation(projects.domain)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}