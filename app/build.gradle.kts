plugins {
    alias(libs.plugins.lol.android.application)
    alias(libs.plugins.lol.android.application.compose)
    alias(libs.plugins.lol.android.hilt)
}

android {
    namespace = "com.sun5066.lol"
}

dependencies {
    implementation(projects.core.di)
    implementation(projects.presentation)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.kotlinx.coroutines.android)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    implementation(libs.bundles.lifecycle)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}