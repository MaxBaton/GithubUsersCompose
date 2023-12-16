package com.maxbay.githubuserscompose.presentation.viewModel

import com.maxbay.githubuserscompose.domain.models.UserDetails
import com.maxbay.viewmodel.UnidirectionalViewModel

interface UserDetailContract: UnidirectionalViewModel<
        UserDetailContract.State,
        UserDetailContract.Event,
        UserDetailContract.Effect?
        > {
    sealed interface State {
        data object Loading: State
        data object Fail: State
        data class Success(val userDetails: UserDetails): State
    }

    sealed interface Event {
        data object UpButtonClick: Event
    }

    sealed interface Effect {
        data object UpButtonClick: Effect
    }
}