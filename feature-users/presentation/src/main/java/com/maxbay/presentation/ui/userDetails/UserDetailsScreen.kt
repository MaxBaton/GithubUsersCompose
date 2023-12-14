package com.maxbay.presentation.ui.userDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.domain.models.User
import com.maxbay.presentation.viewModel.userDetails.UserDetailContract

@Composable
fun UserDetailsScreen(
    uiState: UserDetailContract.State,
    onUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        UserDetailContract.State.Fail -> {}
        is UserDetailContract.State.FailWithException -> {}
        UserDetailContract.State.Loading -> {}
        is UserDetailContract.State.Success -> {
            UserDetailsItem(user = uiState.user)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserDetailsScreenPreview() {
    GithubUsersComposeTheme {
//        UserDetailsScreen()
    }
}