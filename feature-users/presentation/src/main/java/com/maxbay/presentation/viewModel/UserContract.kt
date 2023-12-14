package com.maxbay.presentation.viewModel

import com.maxbay.domain.models.User
import com.maxbay.viewmodel.UnidirectionalViewModel

interface UserContract: UnidirectionalViewModel<
        UserContract.State,
        UserContract.Event,
        UserContract.Effect?
        > {

    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class FailWithException(val message: String): State
        data class Success(val users: List<User>): State
    }

    sealed interface Event {
        data class UserItemClick(val id: Int): Event
    }

    sealed interface Effect {
        data class UserItemClick(val id: Int): Effect
    }
}