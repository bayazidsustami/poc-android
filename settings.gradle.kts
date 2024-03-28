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
include(":app")
include(":demoapp")
include(":cores:core_network")
include(":features:home:home_discover")
include(":features:home:home_favorites")
include(":commons:components")
