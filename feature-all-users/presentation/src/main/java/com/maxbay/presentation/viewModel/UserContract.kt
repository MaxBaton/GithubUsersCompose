package com.maxbay.presentation.viewModel

import com.maxbay.domain.models.User
import com.maxbay.viewmodel.UnidirectionalViewModel

private const val EMPTY = ""
interface UserContract: UnidirectionalViewModel<
        UserContract.State,
        UserContract.Event,
        UserContract.Effect?
        > {

    data class State(
        val users: List<User>,
        val search: String,
        val loadingState: LoadingState
    ) {
        sealed interface LoadingState {
            data object Loading: LoadingState
            data object Fail: LoadingState
            data class FailWithException(val message: String): LoadingState
            data object Success: LoadingState

        }

        companion object {
            fun initial() = State(
                users = emptyList(),
                search = EMPTY,
                loadingState = State.LoadingState.Loading
            )
        }
    }

    sealed interface Event {
        data class UserItemClick(val id: Int): Event
        data class Search(val search: String): Event
    }

    sealed interface Effect {
        data class UserItemClick(val id: Int): Effect
    }
}