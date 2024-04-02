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

    implementation(project(":features:home:home_discover"))
    //implementation(project(":features:home:home_favorites"))
    implementation(project(":cores:core_application"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    implementation(libs.activity)
    implementation(libs.costraint.layout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}