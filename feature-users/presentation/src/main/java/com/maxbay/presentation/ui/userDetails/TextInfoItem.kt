package com.maxbay.presentation.ui.userDetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import com.maxbay.core.ui.theme.space8
import com.maxbay.presentation.R

@Composable
fun TextInfoItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(space8)
    ) {
        Text(
            text = stringResource(id = R.string.text_info_title_template, title),
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun TextInfoItemPreview() {
    GithubUsersComposeTheme {
        TextInfoItem(
            title = "title",
            value = "value"
        )
    }
}