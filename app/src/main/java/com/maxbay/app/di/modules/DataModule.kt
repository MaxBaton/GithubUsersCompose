package com.maxbay.app.di.modules

import android.content.Context
import com.maxbay.app.db.AppDatabase
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
}