package com.maxbay.app.di.modules

import com.maxbay.app.network.AppRetrofit
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return AppRetrofit.create()
    }
}