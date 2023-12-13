package com.maxbay.presentation.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.domain.models.User

@Composable
fun UserItems(
    userItems: List<User>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(userItems) { user ->
            Text(text = user.login)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserItemsPreview() {
    GithubUsersComposeTheme {
        UserItems(userItems = emptyList())
    }
}