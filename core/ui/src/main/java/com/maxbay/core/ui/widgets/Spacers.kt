package com.maxbay.core.ui.widgets

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.maxbay.core.ui.theme.space16
import com.maxbay.core.ui.theme.space8

@Composable
fun Spacer8() {
    Spacer(modifier = Modifier.height(space8))
}

@Composable
fun Spacer16() {
    Spacer(modifier = Modifier.height(space16))
}