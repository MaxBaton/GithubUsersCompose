package com.maxbay.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.presentation.viewModel.UserContract

@Composable
fun UsersScreen(
    uiState: UserContract.State,
    modifier: Modifier = Modifier,
    onItemClick: (id: Int) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onPrimary
    ) {
        when(uiState) {
            UserContract.State.Fail -> Unit
            is UserContract.State.FailWithException -> Unit
            UserContract.State.Loading -> Unit
            is UserContract.State.Success -> {
                UserItems(userItems = uiState.users)
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UsersScreenPreview() {
    GithubUsersComposeTheme {
        UsersScreen(
            uiState = UserContract.State.Loading,
            modifier = Modifier.fillMaxSize(),
            onItemClick = {}
        )
    }
}