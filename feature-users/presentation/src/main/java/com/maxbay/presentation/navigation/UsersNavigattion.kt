package com.maxbay.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.navigation

const val USERS_ROUTE = "USERS_ROUTE"

fun NavGraphBuilder.users(onItemClick: (id: Int) -> Unit) {
    navigation(
        startDestination = AllUsersDestination.route,
        route = USERS_ROUTE
    ) {
        allUsers(onItemClick =  onItemClick)
    }
}