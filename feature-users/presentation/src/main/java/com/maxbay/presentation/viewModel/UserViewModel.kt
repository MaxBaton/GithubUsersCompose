package com.maxbay.presentation.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.ObserveUsersUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UserViewModel(
    private val observeUsersUseCase: ObserveUsersUseCase
): ViewModel(), UserContract {
    private val _uiState = MutableStateFlow<UserContract.State>(UserContract.State.Loading)
    override val uiState: StateFlow<UserContract.State> = _uiState.asStateFlow()

    private val _effect = MutableStateFlow<UserContract.Effect?>(null)
    override val effect: StateFlow<UserContract.Effect?> = _effect.asStateFlow()

    init {
        observeUsers()
    }

    override fun handleEvent(event: UserContract.Event) {
        when(event) {
            is UserContract.Event.UserItemClick -> {
                onUserItemClick(id = event.id)
            }
        }
    }

    override fun consume() {
        _effect.update {
            null
        }
    }

    private fun observeUsers() {
        val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
            _uiState.update {
                UserContract.State.FailWithException(message = throwable.message.toString())
            }
        }

        viewModelScope.launch(context = exceptionHandler) {
            observeUsersUseCase.execute().collect { users ->
                if (users.isNotEmpty()) {
                    _uiState.update {
                        UserContract.State.Success(users = users)
                    }
                }else {
                    _uiState.update {
                        UserContract.State.Fail
                    }
                }
            }
        }
    }

    private fun onUserItemClick(id: Int) {
        _effect.update {
            UserContract.Effect.UserItemClick(id = id)
        }
    }

    @Suppress("UNCHECKED_CAST")
    internal class Factory(
        private val observeUsersUseCase: ObserveUsersUseCase
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(
                observeUsersUseCase = observeUsersUseCase
            ) as T
        }
    }
}