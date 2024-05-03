plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.pocandroid"

    defaultConfig {
        applicationId = "com.example.pocandroid"
        versionCode = 1
        versionName = "1.0"
    }
}

dependencies {

    implementation(project(":cores:core_application"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    implementation(libs.costraint.layout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}