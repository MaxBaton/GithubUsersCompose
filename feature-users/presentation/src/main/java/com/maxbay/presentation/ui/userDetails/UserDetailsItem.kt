package com.maxbay.presentation.ui.userDetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.domain.models.UserDetails

@Composable
fun UserDetailsItem(
    userDetails: UserDetails,
    modifier: Modifier = Modifier
) {
    Text(text = "${userDetails.name}\n${userDetails.email}\n${userDetails.company}")
}

@Composable
@Preview(showBackground = true)
fun UserDetailsItemPreview() {
    GithubUsersComposeTheme {
//        UserDetailsItem()
    }
}