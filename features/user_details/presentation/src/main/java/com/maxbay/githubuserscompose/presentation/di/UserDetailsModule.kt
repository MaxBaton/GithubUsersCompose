package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository
import com.maxbay.githubuserscompose.domain.usecase.GetUserDetailsByIdUseCase
import dagger.Module
import dagger.Provides

@Module
class UserDetailsModule {
    @Provides
    fun provideGetUserDetailsByIdUseCase(repository: UserDetailsRepository): GetUserDetailsByIdUseCase {
        return GetUserDetailsByIdUseCase(repository = repository)
    }
}