plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
}

android {
    namespace = "com.example.commons.components"
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
}