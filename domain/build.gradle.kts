plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.hilt)
}

android {
    namespace = "com.sun5066.domain"
}

dependencies {
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}