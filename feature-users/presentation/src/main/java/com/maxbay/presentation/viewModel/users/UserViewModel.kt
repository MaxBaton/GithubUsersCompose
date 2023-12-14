package com.maxbay.presentation.viewModel.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.ObserveUsersUseCase
import com.maxbay.domain.usecase.SearchUsersUceCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

private const val EMPTY = ""

class UserViewModel(
    private val observeUsersUseCase: ObserveUsersUseCase,
    private val searchUsersUceCase: SearchUsersUceCase
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
            is UserContract.Event.Search -> {
                onSearch(search = event.search)
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
                        UserContract.State.Success(
                            users = users,
                            search = EMPTY
                        )
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

    private fun onSearch(search: String) {
        viewModelScope.launch {
            searchUsersUceCase.execute(param = search)

            _uiState.update { currentState ->
                if (currentState is UserContract.State.Success) {
                    UserContract.State.Success(
                        users = currentState.users,
                        search = search
                    )
                }else {
                    currentState
                }
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    internal class Factory(
        private val observeUsersUseCase: ObserveUsersUseCase,
        private val searchUsersUceCase: SearchUsersUceCase
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UserViewModel(
                observeUsersUseCase = observeUsersUseCase,
                searchUsersUceCase = searchUsersUceCase
            ) as T
        }
    }
}