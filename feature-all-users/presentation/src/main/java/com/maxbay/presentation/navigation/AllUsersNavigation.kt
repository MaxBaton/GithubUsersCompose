package com.maxbay.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.gefest.di.DiProvider
import com.maxbay.domain.usecase.ObserveUsersUseCase
import com.maxbay.domain.usecase.SearchUsersUceCase
import com.maxbay.navigation.NavDestination
import com.maxbay.presentation.ui.UsersScreen
import com.maxbay.presentation.viewModel.UserContract
import com.maxbay.presentation.viewModel.UserViewModel
import com.maxbay.viewmodel.userEffects

fun NavGraphBuilder.allUsers(onItemClick: (id: Int) -> Unit) {
    composable(route = AllUsersDestination.route) {
        val viewModel: UserViewModel = viewModel(
            factory = UserViewModel.Factory(
                observeUsersUseCase = DiProvider.di.get(class_ = ObserveUsersUseCase::class),
                searchUsersUceCase = DiProvider.di.get(class_ = SearchUsersUceCase::class)
            )
        )
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        viewModel.userEffects { effect ->
            when(effect) {
                is UserContract.Effect.UserItemClick -> onItemClick(effect.id)
                null -> Unit
            }
        }

        UsersScreen(
            uiState = uiState,
            onItemClick = { userId ->
                viewModel.handleEvent(event = UserContract.Event.UserItemClick(id = userId))
            },
            onSearch = { search ->
                viewModel.handleEvent(event = UserContract.Event.Search(search = search))
            }
        )
    }
}

object AllUsersDestination: NavDestination {
    override val route = "usersDestination"
}