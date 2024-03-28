plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.home.favorites"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}