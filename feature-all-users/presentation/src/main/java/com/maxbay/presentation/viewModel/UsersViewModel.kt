package com.maxbay.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.maxbay.domain.usecase.ObserveUsersUseCase

class UsersViewModel(
    private val observeUsersUseCase: ObserveUsersUseCase
): ViewModel() {

    @Suppress("UNCHECKED_CAST")
    internal class Factory(
        private val observeUsersUseCase: ObserveUsersUseCase
    ): ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return UsersViewModel(
                observeUsersUseCase = observeUsersUseCase
            ) as T
        }
    }
}