plugins {
    alias(libs.plugins.lol.android.library)
    alias(libs.plugins.lol.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    defaultConfig {
        val asiaAccountUrl = "https://asia.api.riotgames.com/riot/account/"
        val krBaseUrl = "https://kr.api.riotgames.com/lol/"
        val token = "RGAPI-e984c13a-bb71-48a4-ab5d-33bbdac8cbc4"

        buildConfigField("String", "ASIA_ACCOUNT_URL", "\"$asiaAccountUrl\"")
        buildConfigField("String", "KR_BASE_URL", "\"$krBaseUrl\"")
        buildConfigField("String", "TOKEN", "\"$token\"")
    }
    namespace = "com.sun5066.di"
}

dependencies {
    implementation(projects.core.config)
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