package com.maxbay.githubuserscompose.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.maxbay.githubuserscompose.presentation.di.AllUsersFeatureDepsProvider
import com.maxbay.githubuserscompose.presentation.di.DaggerAllUsersComponent
import com.maxbay.navigation.NavDestination
import com.maxbay.githubuserscompose.presentation.ui.UsersScreen
import com.maxbay.githubuserscompose.presentation.viewModel.UserContract
import com.maxbay.githubuserscompose.presentation.viewModel.UserViewModel
import com.maxbay.viewmodel.userEffects

fun NavGraphBuilder.allUsers(onItemClick: (id: Int) -> Unit) {
    composable(route = AllUsersDestination.route) {
        val allUsersComponent = DaggerAllUsersComponent
            .builder()
            .addDeps(allUsersFeatureDeps = AllUsersFeatureDepsProvider.deps)
            .build()

        val viewModel: UserViewModel = viewModel(factory = allUsersComponent.userViewModelFactory)
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