package com.maxbay.app

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.gefest.di.DiProvider
import com.gefest.di.GlobalDi
import com.maxbay.app.db.AppDatabase
import com.maxbay.app.di.GlobalDiImpl
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.network.api.UserApiHelper
import com.maxbay.data.network.factory.AppRetrofit
import com.maxbay.data.network.impl.UserApiHelperImpl
import com.maxbay.data.repository.UserRepositoryImpl
import com.maxbay.data.storage.database.api.DatabaseStorage
import com.maxbay.data.storage.database.dao.UserDao
import com.maxbay.data.storage.database.impl.DatabaseStorageImpl
import com.maxbay.data.storage.prefrenses.PreferencesStorage
import com.maxbay.data.storage.prefrenses.PreferencesStorageImpl
import com.maxbay.domain.repository.UserRepository
import com.maxbay.domain.usecase.ObserveUsersUseCase
import retrofit2.Retrofit


private const val DATA_STORE_NAME = "github_users_app_data_store"

class App: Application() {
    private val dataStore: DataStore<Preferences> by preferencesDataStore(name = DATA_STORE_NAME)

    override fun onCreate() {
        super.onCreate()
        DiProvider.di = initDi()
    }

    private fun initDi(): GlobalDi {
        val di = GlobalDiImpl()

        initDbFeature(di = di)
        initFeatureAllUsers(di = di)

        return di
    }

    private fun initDbFeature(di: GlobalDi) {
        di.add(
            key = AppDatabase::class,
            object_ = AppDatabase.create(context = this)
        )

        di.add(
            key = UserDao::class,
            object_ = di.get(class_ = AppDatabase::class).userDao()
        )
    }

    private fun initFeatureAllUsers(di: GlobalDi) {
        di.add(
            key = Retrofit::class,
            object_ = AppRetrofit.create()
        )

        di.add(
            key = UserApi::class,
            object_ = di.get(class_ = Retrofit::class).create(UserApi::class.java)
        )

        di.add(
            key = UserApiHelper::class,
            object_ = UserApiHelperImpl(userApi = di.get(class_ = UserApi::class))
        )

        di.add(
            key = PreferencesStorage::class,
            object_ = PreferencesStorageImpl(dataStore = this.dataStore)
        )

        di.add(
            key = DatabaseStorage::class,
            object_ = DatabaseStorageImpl(dao = di.get(class_ = UserDao::class))
        )

        di.add(
            key = UserRepository::class,
            object_ = UserRepositoryImpl(
                userApiHelper = di.get(class_ = UserApiHelper::class),
                preferencesStorage = di.get(class_ = PreferencesStorage::class),
                databaseStorage = di.get(class_ = DatabaseStorage::class)
            )
        )

        di.add(
            key = ObserveUsersUseCase::class,
            object_ = ObserveUsersUseCase(repository = di.get(class_ = UserRepository::class))
        )
    }
}