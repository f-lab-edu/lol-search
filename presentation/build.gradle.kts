plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.library.compose)
    alias(libs.plugins.lol.android.hilt)
}

android {
    namespace = "com.sun5066.presentation"
}

dependencies {
    implementation(projects.core.base)
    implementation(projects.core.config)
    implementation(projects.domain)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.coroutines.android)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}