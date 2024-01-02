package com.maxbay.githubuserscompose.presentation.di

import com.maxbay.githubuserscompose.presentation.viewModel.UserDetailsViewModelFactoryAssisted
import dagger.Component

@UserDetailsScope
@Component(
    modules = [UserDetailsModule::class],
    dependencies = [UserDetailsFeatureDeps::class]
)
interface UserDetailsComponent {
    val userDetailsViewModelFactoryAssisted: UserDetailsViewModelFactoryAssisted

    @Component.Builder
    interface Builder {
        fun addDeps(userDetailsFeatureDeps: UserDetailsFeatureDeps): Builder
        fun build(): UserDetailsComponent
    }
}