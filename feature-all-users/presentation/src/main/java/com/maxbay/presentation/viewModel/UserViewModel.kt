package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.maxbay.domain.usecase.ObserveUsersUseCase
import kotlinx.coroutines.launch

class UserViewModel(
    private val observeUsersUseCase: ObserveUsersUseCase
): ViewModel() {

    init {
        observeUsers()
    }

    private fun observeUsers() {
        viewModelScope.launch {
            observeUsersUseCase.execute().collect { users ->
                val a = users
                val s = users.size
            }
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