package com.maxbay.presentation.viewModel.userDetails

import com.maxbay.domain.models.User
import com.maxbay.presentation.viewModel.users.UserContract
import com.maxbay.viewmodel.UnidirectionalViewModel

interface UserDetailContract: UnidirectionalViewModel<
        UserDetailContract.State,
        UserDetailContract.Event,
        UserDetailContract.Effect?
        > {
    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class FailWithException(val message: String): State
        data class Success(val user: User): State
    }

    sealed interface Event {

    }

    sealed interface Effect {

    }
}