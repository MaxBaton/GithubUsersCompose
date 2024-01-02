package com.maxbay.githubuserscompose.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.space16
import com.maxbay.githubuserscompose.domain.models.User

@Composable
fun UserItems(
    users: List<com.maxbay.githubuserscompose.domain.models.User>,
    modifier: Modifier = Modifier,
    onItemClick: (id: Int) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(space16)
    ) {
        items(users) { user ->
            UserItem(
                user = user,
                onItemClick = onItemClick
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserItemsPreview() {
    GithubUsersComposeTheme {
//        UserItems(userItems = emptyList())
    }
}