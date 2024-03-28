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
    implementation(project(":commons:common_coroutine"))
    implementation(project(":commons:components"))

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material.design)
    implementation(libs.activity)
    implementation(libs.costraint.layout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.android.junit)
    androidTestImplementation(libs.android.espresso)
}