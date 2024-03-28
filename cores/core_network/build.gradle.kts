plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.core.network"
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":cores:core_application"))

    implementation(libs.bundles.network)

    testImplementation(libs.junit)
}