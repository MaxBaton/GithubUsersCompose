package com.maxbay.app

import android.app.Application
import com.gefest.di.DiProvider
import com.gefest.di.GlobalDi
import com.maxbay.app.di.GlobalDiImpl
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.network.api.UserApiHelper
import com.maxbay.data.network.factory.AppRetrofit
import com.maxbay.data.network.impl.UserApiHelperImpl
import com.maxbay.data.repository.UserRepositoryImpl
import com.maxbay.domain.repository.UserRepository
import com.maxbay.domain.usecase.ObserveUsersUseCase
import retrofit2.Retrofit

class GithubUsersComposeApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        DiProvider.di = initDi()
    }

    private fun initDi(): GlobalDi {
        val di = GlobalDiImpl()

        initFeatureAllUsers(di = di)

        return di
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
            key = UserRepository::class,
            object_ = UserRepositoryImpl(
                userApiHelper = di.get(class_ = UserApiHelper::class)
            )
        )

        di.add(
            key = ObserveUsersUseCase::class,
            object_ = ObserveUsersUseCase(repository = di.get(class_ = UserRepository::class))
        )
    }
}