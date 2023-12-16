package com.maxbay.core.ui.widgets.topbar

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.R
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.zeroValue

@ExperimentalMaterial3Api
@Composable
fun TopBarWithIconBack(
    title:String,
    onClickUpButton: () -> Unit
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickUpButton) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_left_arrow),
                    contentDescription = stringResource(id = R.string.ic_arrow_back_description)
                )
            }
        },
        windowInsets = WindowInsets(
            left = zeroValue,
            right = zeroValue,
            top = zeroValue,
            bottom = zeroValue
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
internal fun TopBarWithIconBackPreview() {
    GithubUsersComposeTheme {
        TopBarWithIconBack(title = "Title") {}
    }
}