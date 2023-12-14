package com.maxbay.presentation.ui.userDetails

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.widgets.FailMessageFullScreenItem
import com.maxbay.core.ui.widgets.ProgressbarFullScreenItem
import com.maxbay.core.ui.widgets.Spacer8
import com.maxbay.core.ui.widgets.topbar.TopBar
import com.maxbay.core.ui.widgets.topbar.TopBarWithIconBack
import com.maxbay.domain.models.User
import com.maxbay.presentation.R
import com.maxbay.presentation.viewModel.userDetails.UserDetailContract

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserDetailsScreen(
    uiState: UserDetailContract.State,
    onUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    when(uiState) {
        UserDetailContract.State.Fail -> {
            FailMessageFullScreenItem(message = stringResource(id = R.string.fail_load_user_data))
        }

        UserDetailContract.State.Loading -> {
            ProgressbarFullScreenItem()
        }

        is UserDetailContract.State.Success -> {
            Column(modifier = modifier) {
                TopBarWithIconBack(
                    title = uiState.user.login,
                    onClickUpButton = onUpClick
                )
                Spacer8()
                UserDetailsItem(user = uiState.user)
            }
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