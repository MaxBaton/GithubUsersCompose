package com.maxbay.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.maxbay.presentation.navigation.AllUsersDestination
import com.maxbay.presentation.navigation.USERS_ROUTE
import com.maxbay.presentation.navigation.allUsers
import com.maxbay.presentation.navigation.users

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(
        navController = navController,
        startDestination = USERS_ROUTE
    ) {
//        users(onItemClick = {})
        users(onItemClick = {})
    }
}