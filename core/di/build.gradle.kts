import java.util.Properties

plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.sun5066.di"

    val localPropertiesFile = rootProject.file("local.properties")
    val localProperties = Properties()

    if (localPropertiesFile.exists()) {
        localProperties.load(localPropertiesFile.inputStream())
    }

    defaultConfig {
        val asiaAccountUrl = localProperties.getProperty("asiaAccountUrl", "")
        val krBaseUrl = localProperties.getProperty("krBaseUrl", "")
        val token = localProperties.getProperty("token", "")

        buildConfigField("String", "ASIA_ACCOUNT_URL", "\"$asiaAccountUrl\"")
        buildConfigField("String", "KR_BASE_URL", "\"$krBaseUrl\"")
        buildConfigField("String", "TOKEN", "\"$token\"")
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.domain)
    implementation(projects.data.source)
    implementation(projects.data.restApi)

    implementation(platform(libs.okhttp.bom))
    implementation(libs.bundles.retrofit)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}