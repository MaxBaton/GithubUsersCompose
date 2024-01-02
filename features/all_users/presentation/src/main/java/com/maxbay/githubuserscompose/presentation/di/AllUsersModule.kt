package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.domain.repository.UserRepository
import com.maxbay.githubuserscompose.domain.usecase.ObserveUsersUseCase
import com.maxbay.githubuserscompose.domain.usecase.SearchUsersUceCase
import com.maxbay.githubuserscompose.presentation.viewModel.UserViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AllUsersModule {
    @Provides
    fun provideObserveUsersUseCase(repository: UserRepository): ObserveUsersUseCase {
        return ObserveUsersUseCase(repository = repository)
    }

    @Provides
    fun provideSearchUsersUceCase(repository: UserRepository): SearchUsersUceCase {
        return SearchUsersUceCase(repository = repository)
    }

    @Provides
    fun provideUserViewModelFactory(
        observeUsersUseCase: ObserveUsersUseCase,
        searchUsersUceCase: SearchUsersUceCase
    ): UserViewModelFactory {
        return UserViewModelFactory(
            observeUsersUseCase = observeUsersUseCase,
            searchUsersUceCase = searchUsersUceCase
        )
    }
}