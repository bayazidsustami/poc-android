plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.core.network"
    defaultConfig {
        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/3/\"")
        buildConfigField("String", "API_KEY", "\"1f866de25eb9c3ef281b188410e0ebeb\"")
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(project(":cores:core_application"))

    api(libs.bundles.network)

    testImplementation(libs.junit)
}