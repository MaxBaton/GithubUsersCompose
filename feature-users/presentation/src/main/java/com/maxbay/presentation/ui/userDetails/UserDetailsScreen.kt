package com.maxbay.presentation.ui.userDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.domain.models.User

@Composable
fun UserDetailsScreen(
    user: User,
    modifier: Modifier = Modifier
) {
    UserDetailsItem(user = user)
}

@Composable
@Preview(showBackground = true)
fun UserDetailsScreenPreview() {
    GithubUsersComposeTheme {
//        UserDetailsScreen()
    }
}