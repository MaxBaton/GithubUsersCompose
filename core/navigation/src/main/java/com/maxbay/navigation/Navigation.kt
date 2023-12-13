package com.maxbay.navigation

interface NavDestination {
    val route: String
}

object UsersDestination: NavDestination {
    override val route = "USERS_SCREEN_DESTINATION"

}