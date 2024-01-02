package com.maxbay.app

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.gefest.di.DiProvider
import com.gefest.di.GlobalDi
import com.maxbay.app.db.AppDatabase
import com.maxbay.app.di.DaggerAppComponent
import com.maxbay.app.di.DaggerProvider
import com.maxbay.app.di.GlobalDiImpl
import com.maxbay.app.network.AppRetrofit
import com.maxbay.githubuserscompose.presentation.di.AllUsersFeatureDepsProvider
import com.maxbay.githubuserscompose.presentation.di.UserDetailsFeatureDepsProvider
import retrofit2.Retrofit


private const val DATA_STORE_NAME = "github_users_app_data_store"

class App: Application() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    override fun onCreate() {
        super.onCreate()
        DiProvider.di = initDi()
        setupDagger()
    }

    private fun initDi(): GlobalDi {
        val di = GlobalDiImpl()

        initDbFeature(di = di)
        initFeatureAllUsers(di = di)
        initFeatureUserDetails(di = di)

        return di
    }

    private fun initDbFeature(di: GlobalDi) {
        di.add(
            key = AppDatabase::class,
            object_ = AppDatabase.create(context = this)
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.database.dao.UserDao::class,
            object_ = di.get(class_ = AppDatabase::class).userDao()
        )
    }

    private fun initFeatureAllUsers(di: GlobalDi) {
        di.add(
            key = Retrofit::class,
            object_ = AppRetrofit.create()
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.network.UserApi::class,
            object_ = di.get(class_ = Retrofit::class).create(com.maxbay.githubuserscompose.data.network.UserApi::class.java)
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorage::class,
            object_ = com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorageImpl(
                dataStore = this.dataStore
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage::class,
            object_ = com.maxbay.githubuserscompose.data.storage.database.impl.DatabaseStorageImpl(
                dao = di.get(class_ = com.maxbay.githubuserscompose.data.storage.database.dao.UserDao::class)
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.domain.repository.UserRepository::class,
            object_ = com.maxbay.githubuserscompose.data.repository.UserRepositoryImpl(
                userApi = di.get(class_ = com.maxbay.githubuserscompose.data.network.UserApi::class),
                preferencesStorage = di.get(class_ = com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorage::class),
                databaseStorage = di.get(class_ = com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage::class)
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.domain.usecase.ObserveUsersUseCase::class,
            object_ = com.maxbay.githubuserscompose.domain.usecase.ObserveUsersUseCase(
                repository = di.get(
                    class_ = com.maxbay.githubuserscompose.domain.repository.UserRepository::class
                )
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.domain.usecase.SearchUsersUceCase::class,
            object_ = com.maxbay.githubuserscompose.domain.usecase.SearchUsersUceCase(
                repository = di.get(
                    class_ = com.maxbay.githubuserscompose.domain.repository.UserRepository::class
                )
            )
        )
    }

    private fun initFeatureUserDetails(di: GlobalDi) {
        di.add(
            key = com.maxbay.githubuserscompose.data.network.UserDetailsApi::class,
            object_ = di.get(class_ = Retrofit::class).create(com.maxbay.githubuserscompose.data.network.UserDetailsApi::class.java)
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.database.dao.UserDetailsDao::class,
            object_ = di.get(class_ = AppDatabase::class).userDetailsDao()
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.database.api.DatabaseUserDetailsStorage::class,
            object_ = com.maxbay.githubuserscompose.data.storage.database.impl.DatabaseUserDetailsStorageImpl(
                dao = di.get(class_ = com.maxbay.githubuserscompose.data.storage.database.dao.UserDetailsDao::class)
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.data.storage.preferences.PreferencesUserDetailsStorage::class,
            object_ = com.maxbay.githubuserscompose.data.storage.preferences.PreferencesUserDetailsStorageImpl(
                dataStore = this.dataStore
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository::class,
            object_ = com.maxbay.githubuserscompose.data.repository.UserDetailsRepositoryImpl(
                userDetailsApi = di.get(class_ = com.maxbay.githubuserscompose.data.network.UserDetailsApi::class),
                databaseStorage = di.get(class_ = com.maxbay.githubuserscompose.data.storage.database.api.DatabaseUserDetailsStorage::class),
                preferencesStorage = di.get(class_ = com.maxbay.githubuserscompose.data.storage.preferences.PreferencesUserDetailsStorage::class)
            )
        )

        di.add(
            key = com.maxbay.githubuserscompose.domain.usecase.GetUserDetailsByIdUseCase::class,
            object_ = com.maxbay.githubuserscompose.domain.usecase.GetUserDetailsByIdUseCase(
                repository = di.get(class_ = com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository::class)
            )
        )
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