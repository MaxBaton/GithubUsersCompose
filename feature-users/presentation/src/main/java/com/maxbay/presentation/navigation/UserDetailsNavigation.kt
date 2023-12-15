package com.maxbay.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.gefest.di.DiProvider
import com.maxbay.domain.usecase.GetUserByIdUseCase
import com.maxbay.domain.usecase.GetUserDetailsByIdUseCase
import com.maxbay.navigation.NavDestination
import com.maxbay.presentation.ui.userDetails.UserDetailsScreen
import com.maxbay.presentation.viewModel.userDetails.UserDetailsViewModel

fun NavGraphBuilder.userDetails(onUpClick: () -> Unit) {
    composable(
        route = UserDetailsNavDestination.routeWithArgs,
        arguments = UserDetailsNavDestination.arguments
    ) { navBackStackEntry ->
        val userId = navBackStackEntry.arguments?.getInt(UserDetailsNavDestination.userIdArgument) ?: 0
        val viewModel: UserDetailsViewModel = viewModel(
            factory = UserDetailsViewModel.Factory(
                userId = userId,
                getUserByIdUseCase = DiProvider.di.get(class_ = GetUserByIdUseCase::class),
                getUserDetailsByIdUseCase = DiProvider.di.get(class_ = GetUserDetailsByIdUseCase::class)
            )
        )
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        UserDetailsScreen(
            uiState = uiState,
            onUpClick = onUpClick
        )
    }
}

internal object UserDetailsNavDestination: NavDestination {
    const val userIdArgument = "userIdArgument"
    override val route: String = "userDetailsDestination/${userIdArgument}"
    val routeWithArgs = "$route/{$userIdArgument}"
    val arguments = listOf(
        navArgument(
            name = userIdArgument,
            builder = { type = NavType.IntType }
        )
    )
}

fun NavHostController.navigateToUserDetails(id: Int) {
    this.navigate(route = "${UserDetailsNavDestination.route}/$id")
}

