plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.home.discover"
}

dependencies {

    implementation(project(":cores:core_network"))
    implementation(project(":cores:core_application"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}