package com.maxbay.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.maxbay.presentation.navigation.USERS_ROUTE
import com.maxbay.presentation.navigation.users

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = USERS_ROUTE
    ) {
        users(
            onItemClick = {},
            onUpClick = navController::popBackStack
        )
    }
}