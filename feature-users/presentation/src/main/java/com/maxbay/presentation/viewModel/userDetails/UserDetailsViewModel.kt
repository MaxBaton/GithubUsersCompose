package com.maxbay.presentation.viewModel.userDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.GetUserDetailsByIdUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserDetailsViewModel(
    private val userId: Int,
    private val getUserDetailsByIdUseCase: GetUserDetailsByIdUseCase
): ViewModel(), UserDetailContract {
    private val _uiState = MutableStateFlow<UserDetailContract.State>(UserDetailContract.State.Loading)
    override val uiState: StateFlow<UserDetailContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<UserDetailContract.Effect?>(null)
    override val effect: StateFlow<UserDetailContract.Effect?> = _effect.asStateFlow()

    init {
        loadUserById()
    }

    override fun handleEvent(event: UserDetailContract.Event) {
        TODO("Not yet implemented")
    }

    override fun consume() {
        _effect.update {
            null
        }
    }

    private fun loadUserById() {
        val exceptionHandler = CoroutineExceptionHandler { _, _ ->
            _uiState.update {
                UserDetailContract.State.Fail
            }
        }

        viewModelScope.launch(exceptionHandler) {
            val userDetails = getUserDetailsByIdUseCase.execute(param = userId)
            _uiState.update {
                UserDetailContract.State.Success(userDetails = userDetails)
            }
        }
    }

    internal class Factory(
        private val userId: Int,
        private val getUserDetailsByIdUseCase: GetUserDetailsByIdUseCase
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserDetailsViewModel(
                userId = userId,
                getUserDetailsByIdUseCase = getUserDetailsByIdUseCase
            ) as T
        }
    }
}