package com.maxbay.presentation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gefest.di.DiProvider
import com.maxbay.domain.usecase.ObserveUsersUseCase
import com.maxbay.navigation.UsersDestination
import com.maxbay.presentation.ui.UsersScreen
import com.maxbay.presentation.viewModel.UserViewModel

fun NavGraphBuilder.users(onItemClick: (id: Int) -> Unit) {
    composable(route = UsersDestination.route) {
        val viewModel: UserViewModel = viewModel(
            factory = UserViewModel.Factory(
                observeUsersUseCase = DiProvider.di.get(class_ = ObserveUsersUseCase::class)
            )
        )
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        UsersScreen(
            uiState = uiState,
            onItemClick = onItemClick
        )
    }
}