package com.maxbay.presentation.viewModel.users

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
        data class Success(
            val users: List<User>,
            val search: String
        ): State
    }

    sealed interface Event {
        data class UserItemClick(val id: Int): Event
        data class Search(val search: String): Event
    }

    sealed interface Effect {
        data class UserItemClick(val id: Int): Effect
    }
}