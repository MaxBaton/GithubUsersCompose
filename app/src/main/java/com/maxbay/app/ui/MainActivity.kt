package com.maxbay.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maxbay.app.navigation.AppNavHost
import com.maxbay.core.ui.theme.GithubUsersComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubUsersComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.onPrimary
                ) {
                    GithubUsersComposeApp()
                }
            }
        }
    }

    @Composable
    private fun GithubUsersComposeApp() {
        GithubUsersComposeTheme {
            AppNavHost()
        }
    }
}