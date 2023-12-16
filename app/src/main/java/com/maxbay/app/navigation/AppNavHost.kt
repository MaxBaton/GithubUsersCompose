package com.maxbay.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maxbay.githubuserscompose.presentation.navigation.navigateToUserDetails
import com.maxbay.githubuserscompose.presentation.navigation.userDetails
import com.maxbay.presentation.navigation.AllUsersDestination
import com.maxbay.presentation.navigation.allUsers

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = AllUsersDestination.route
    ) {
        allUsers(onItemClick = navController::navigateToUserDetails)
        userDetails(onUpClick = navController::popBackStack)
    }
}