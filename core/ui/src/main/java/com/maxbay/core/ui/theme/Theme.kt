package com.maxbay.core.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


val lightColorScheme = lightColorScheme(
    primary = GonzoViolet,
    secondary = MintMorning,
    onPrimary = CodexGray,
    onPrimaryContainer = Black,
    tertiary = White
)

val darkColorScheme = darkColorScheme(
    primary = GonzoViolet,
    secondary = MintMorning,
    onPrimary = CodexGray,
    onPrimaryContainer = Black,
    tertiary = White
)

@Composable
fun GithubUsersComposeTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        isDarkTheme -> darkColorScheme
        else -> lightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = isDarkTheme
        }
    }

    MaterialTheme(colorScheme = colorScheme, content = content, typography = Typography)
}