plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.android.kotlin)
    id("base-main-plugin")
}

android {
    namespace = "com.example.common.coroutine"
}

dependencies {
    api(libs.android.coroutine)
}