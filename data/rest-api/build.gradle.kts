plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sun5066.rest_api"
}

dependencies {
    implementation(projects.data.source)
    implementation(projects.core.config)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.coroutines.android)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}