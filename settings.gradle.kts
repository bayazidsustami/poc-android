pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "poc-android"
includeBuild("build_plugins")
//apply(from = "./build_config/build_main_config.gradle")
//apply(from = "./build_config/build_home_discover_feature.gradle")
//apply(from = "./build_config/build_home_favorite_feature.gradle")