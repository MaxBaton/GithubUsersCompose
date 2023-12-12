package com.maxbay.viewmodel

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kotlinx.coroutines.flow.StateFlow

interface UnidirectionalViewModel<STATE, EVENT, EFFECT> {
    val uiState: StateFlow<STATE>
    val effect: StateFlow<EFFECT>
    fun handleEvent(event: EVENT)
    fun consume()
}

@SuppressLint("ComposableNaming")
@Composable
fun <STATE, EVENT, EFFECT> UnidirectionalViewModel<STATE, EVENT, EFFECT>.userEffects(
    function: (value: EFFECT) -> Unit
) {
    val key by effect.collectAsStateWithLifecycle()

    DisposableEffect(key1 = key) {
        key?.let { localEffect ->
            function(localEffect)
        }

        onDispose {
            consume()
        }
    }
}