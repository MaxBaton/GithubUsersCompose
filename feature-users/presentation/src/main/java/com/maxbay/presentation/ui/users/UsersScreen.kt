package com.maxbay.presentation.ui.users

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.widgets.SearchField
import com.maxbay.core.ui.widgets.Spacer8
import com.maxbay.core.ui.widgets.topbar.TopBar
import com.maxbay.presentation.R
import com.maxbay.presentation.viewModel.users.UserContract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UsersScreen(
    uiState: UserContract.State,
    modifier: Modifier = Modifier,
    onItemClick: (id: Int) -> Unit,
    onSearch: (value: String) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        when(uiState.loadingState) {
            UserContract.State.LoadingState.Fail -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.fail_loading),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }

            is UserContract.State.LoadingState.FailWithException -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.fail_loading_with_exception, uiState.loadingState.message),
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
            UserContract.State.LoadingState.Loading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            is UserContract.State.LoadingState.Success -> {
                Column {
                    TopBar(title = stringResource(id = R.string.title_users))
                    Spacer8()
                    SearchField(
                        value = uiState.search,
                        onValueChange = onSearch,
                        placeholderResId = R.string.search_place_holder,
                        leadingIconResId = R.drawable.ic_search
                    )
                    Spacer8()
                    UserItems(
                        users = uiState.users,
                        onItemClick = onItemClick
                    )
                    Spacer8()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UsersScreenPreview() {
    GithubUsersComposeTheme {
//        UsersScreen(
//            uiState = UserContract.State.Loading,
//            modifier = Modifier.fillMaxSize(),
//            onItemClick = {},
//            onSearch = {}
//        )
    }
}