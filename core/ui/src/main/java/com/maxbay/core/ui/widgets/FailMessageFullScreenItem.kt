package com.maxbay.core.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme

@Composable
fun FailMessageFullScreenItem(
    message: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun FailMessageFullScreenItemPreview() {
    GithubUsersComposeTheme {
        FailMessageFullScreenItem(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.onPrimary),
            message = "Fail message"
        )
    }
}