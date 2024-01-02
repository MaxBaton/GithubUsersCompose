package com.maxbay.app

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.maxbay.app.di.DaggerAppComponent
import com.maxbay.app.di.DaggerProvider
import com.maxbay.githubuserscompose.presentation.di.AllUsersFeatureDepsProvider
import com.maxbay.githubuserscompose.presentation.di.UserDetailsFeatureDepsProvider


private const val DATA_STORE_NAME = "github_users_app_data_store"

class App: Application() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    override fun onCreate() {
        super.onCreate()
        setupDagger()
    }

    private fun setupDagger() {
        val appComponent = DaggerAppComponent
            .builder()
            .addContext(context = this)
            .addDataStore(dataStore = this.dataStore)
            .build()
        DaggerProvider.appComponent = appComponent
        AllUsersFeatureDepsProvider.deps = appComponent
        UserDetailsFeatureDepsProvider.deps = appComponent
    }
}