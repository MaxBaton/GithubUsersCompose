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
include(":core:contract:usecase")
include(":core:contract:viewModel")
include(":core:navigation")
include(":core:utils:data")
include(":features:all_users:domain")
include(":features:all_users:data")
include(":features:all_users:presentation")
include(":features:user_details:domain")
include(":features:user_details:data")
include(":features:user_details:presentation")
