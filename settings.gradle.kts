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

rootProject.name = "GithubUsersCompose"
include(":app")
include(":core:ui")
include(":feature-users:presentation")
include(":feature-users:domain")
include(":feature-users:data")
include(":core:contract:usecase")
include(":core:di")
include(":core:contract:viewModel")
include(":core:navigation")
