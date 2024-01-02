package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.presentation.viewModel.UserViewModelFactory
import dagger.Component

@AllUsersScope
@Component(
    modules = [AllUsersModule::class],
    dependencies = [AllUsersFeatureDeps::class]
)
interface AllUsersComponent {
    val userViewModelFactory: UserViewModelFactory

    @Component.Builder
    interface Builder {
        fun addDeps(allUsersFeatureDeps: AllUsersFeatureDeps): Builder
        fun build(): AllUsersComponent
    }
}