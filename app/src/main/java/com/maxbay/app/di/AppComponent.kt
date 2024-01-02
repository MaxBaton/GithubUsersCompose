package com.maxbay.app.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.maxbay.app.di.modules.DataModule
import com.maxbay.app.di.modules.NetworkModule
import com.maxbay.app.di.modules.RepositoriesModule
import com.maxbay.githubuserscompose.domain.repository.UserRepository
import com.maxbay.githubuserscompose.presentation.di.AllUsersFeatureDeps
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        NetworkModule::class,
        RepositoriesModule::class
    ]
)
interface AppComponent: AllUsersFeatureDeps {
    override val userRepository: UserRepository

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun addContext(context: Context): Builder
        @BindsInstance
        fun addDataStore(dataStore: DataStore<Preferences>): Builder
        fun build(): AppComponent
    }
}