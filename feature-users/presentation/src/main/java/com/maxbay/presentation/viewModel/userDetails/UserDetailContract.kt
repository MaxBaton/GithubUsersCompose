package com.maxbay.presentation.viewModel.userDetails

import com.maxbay.domain.models.UserDetails
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

    }

    sealed interface Effect {

    }
}