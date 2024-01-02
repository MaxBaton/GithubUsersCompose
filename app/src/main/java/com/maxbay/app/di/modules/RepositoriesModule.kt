package com.maxbay.app.di.modules

import com.maxbay.githubuserscompose.data.network.UserApi
import com.maxbay.githubuserscompose.data.repository.UserRepositoryImpl
import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage
import com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorage
import com.maxbay.githubuserscompose.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoriesModule {
    @Singleton
    @Provides
    fun provideUserRepository(
        userApi: UserApi,
        preferencesStorage: PreferencesStorage,
        databaseStorage: DatabaseStorage
    ): UserRepository {
        return UserRepositoryImpl(
            userApi = userApi,
            preferencesStorage = preferencesStorage,
            databaseStorage = databaseStorage
        )
    }
}