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
include(":feature-all-users:presentation")
include(":feature-all-users:domain")
include(":feature-all-users:data")
include(":core:contract:usecase")
include(":core:di")
include(":core:contract:viewModel")
include(":core:navigation")
include(":feature-user-details:domain")
include(":feature-user-details:data")
include(":feature-user-details:presentation")
