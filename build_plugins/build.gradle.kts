plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
}

dependencies {
    implementation(libs.android.gradle)
    implementation(kotlin("gradle-plugin", "1.9.22"))
}

gradlePlugin{
    plugins {
        register("base-main-plugin"){
            id = "base-main-plugin"
            implementationClass = "com.example.build.plugins.AppMainPlugin"
            version = "1.0.0"
        }
    }
}