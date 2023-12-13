package com.maxbay.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maxbay.core.ui.theme.GithubUsersComposeTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import com.gefest.di.DiProvider
import com.maxbay.domain.usecase.ObserveUsersUseCase
import com.maxbay.presentation.viewModel.UserViewModel

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