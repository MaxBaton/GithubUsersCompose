package com.maxbay.app.di.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.maxbay.app.db.AppDatabase
import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage
import com.maxbay.githubuserscompose.data.storage.database.dao.UserDao
import com.maxbay.githubuserscompose.data.storage.database.impl.DatabaseStorageImpl
import com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorage
import com.maxbay.githubuserscompose.data.storage.prefrenses.PreferencesStorageImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return AppDatabase.create(context = context)
    }

    @Singleton
    @Provides
    fun providePreferenceStorage(dataStore: DataStore<Preferences>): PreferencesStorage {
        return PreferencesStorageImpl(dataStore = dataStore)
    }

    @Singleton
    @Provides
    fun provideDatabaseStorage(dao: UserDao): DatabaseStorage {
        return DatabaseStorageImpl(dao = dao)
    }

    @Singleton
    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao {
        return appDatabase.userDao()
    }
}