package com.maxbay.githubuserscompose.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.corner16
import com.maxbay.core.ui.theme.elevation5
import com.maxbay.core.ui.theme.itemHeight200
import com.maxbay.core.ui.theme.padding8
import com.maxbay.core.ui.widgets.Spacer8
import com.maxbay.githubuserscompose.presentation.R
import getTestUser

@Composable
fun UserItem(
    user: com.maxbay.githubuserscompose.domain.models.User,
    modifier: Modifier = Modifier,
    onItemClick: (id: Int) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(itemHeight200)
            .shadow(
                elevation = elevation5,
                shape = RoundedCornerShape(size = corner16)
            )
            .background(
                color = MaterialTheme.colorScheme.tertiary,
                shape = RoundedCornerShape(size = corner16)
            )
            .padding(vertical = padding8)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onItemClick(user.id) }
        ) {
            Column {
                Box(
                    modifier = Modifier
                        .weight(0.8f)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(vertical = padding8)
                            .clip(shape = CircleShape),
                        model = user.avatarUrl,
                        contentDescription = stringResource(id = R.string.ic_user_avatar_description, user.login)
                    )
                }

                Spacer8()

                Box(
                    modifier = Modifier
                        .weight(0.2f)
                        .fillMaxHeight()
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier,
                        text = user.login,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onPrimaryContainer
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun UserItemPreview() {
    GithubUsersComposeTheme {
        UserItem(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary),
            user = getTestUser(),
            onItemClick = {}
        )
    }
}