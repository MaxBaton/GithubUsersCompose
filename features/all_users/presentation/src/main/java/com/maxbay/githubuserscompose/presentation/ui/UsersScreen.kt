package com.maxbay.githubuserscompose.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.padding16
import com.maxbay.core.ui.widgets.FailMessageFullScreenItem
import com.maxbay.core.ui.widgets.ProgressbarFullScreenItem
import com.maxbay.core.ui.widgets.SearchField
import com.maxbay.core.ui.widgets.Spacer8
import com.maxbay.core.ui.widgets.topbar.TopBar
import com.maxbay.githubuserscompose.presentation.R
import com.maxbay.githubuserscompose.presentation.viewModel.UserContract

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
                FailMessageFullScreenItem(message = stringResource(id = R.string.fail_loading))
            }

            is UserContract.State.LoadingState.FailWithException -> {
                FailMessageFullScreenItem(message = stringResource(id = R.string.fail_loading_with_exception, uiState.loadingState.message),)
            }

            UserContract.State.LoadingState.Loading -> {
                ProgressbarFullScreenItem()
            }

            is UserContract.State.LoadingState.Success -> {
                Column {
                    TopBar(title = stringResource(id = R.string.title_users))
                    Spacer8()
                    Column(modifier = Modifier.padding(horizontal = padding16)) {
                        SearchField(
                            modifier = Modifier.fillMaxWidth(),
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