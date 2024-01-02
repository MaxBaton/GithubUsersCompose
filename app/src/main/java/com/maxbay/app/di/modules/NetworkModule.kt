package com.maxbay.app.di.modules

import com.maxbay.app.network.AppRetrofit
import com.maxbay.githubuserscompose.data.network.UserApi
import com.maxbay.githubuserscompose.data.network.UserDetailsApi
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

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi {
        return retrofit.create(UserApi::class.java)
    }

    @Singleton
    @Provides
    fun provideUserDetailsApi(retrofit: Retrofit): UserDetailsApi {
        return retrofit.create(UserDetailsApi::class.java)
    }
}