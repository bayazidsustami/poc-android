package com.example.build.plugins

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import com.example.build.Constants
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class AppMainPlugin: Plugin<Project> {

    override fun apply(target: Project) {

        target.plugins.apply("org.jetbrains.kotlin.kapt")

        val androidExtension = target.project.extensions.getByName("android")
        if (androidExtension is BaseExtension) {
            setupAndroid(androidExtension)
            target.tasks.withType(KotlinCompile::class.java).configureEach{
                androidExtension.apply {
                    kotlinOptions {
                        jvmTarget = "1.8"
                    }
                }
            }
        }

        val daggerVersion = "2.51"
        target.dependencies {
            add("implementation", "com.google.dagger:dagger:$daggerVersion")
            add("kapt", "com.google.dagger:dagger-compiler:$daggerVersion")
        }
    }

    private fun setupAndroid(androidExtension: BaseExtension) {
        androidExtension.apply {
            compileSdkVersion(Constants.TARGET_SDK)
            defaultConfig {
                minSdk = Constants.MIN_SDK
                targetSdk = Constants.TARGET_SDK
                testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
            }

            val proguardFile = "proguard-rules.pro"
            when(this) {
                is LibraryExtension -> {
                    defaultConfig { consumerProguardFiles(proguardFile) }
                }
                is AppExtension -> {
                    buildTypes {
                        getByName("release") {
                            isMinifyEnabled = false
                            proguardFiles(
                                getDefaultProguardFile("proguard-android-optimize.txt"),
                                proguardFile
                            )
                        }
                    }
                }
            }

            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }

        }
    }
}