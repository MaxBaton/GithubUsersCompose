package com.maxbay.presentation.viewModel.userDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class UserDetailsViewModel(
    private val userId: Int
): ViewModel(), UserDetailContract {
    private val _uiState = MutableStateFlow<UserDetailContract.State>(UserDetailContract.State.Loading)
    override val uiState: StateFlow<UserDetailContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<UserDetailContract.Effect?>(null)
    override val effect: StateFlow<UserDetailContract.Effect?> = _effect.asStateFlow()

    override fun handleEvent(event: UserDetailContract.Event) {
        TODO("Not yet implemented")
    }

    override fun consume() {
        _effect.update {
            null
        }
    }

    internal class Factory(
        private val userId: Int
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserDetailsViewModel(
                userId = userId
            ) as T
        }
    }
}