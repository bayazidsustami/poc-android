plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.demoapp"

    defaultConfig {
        applicationId = "com.example.demoapp"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    implementation(libs.activity)
    implementation(libs.costraint.layout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}