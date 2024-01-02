package com.maxbay.app.di

import android.content.Context
import com.maxbay.app.di.modules.DataModule
import com.maxbay.app.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        DataModule::class,
        NetworkModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun addContext(context: Context): Builder
        fun build(): AppComponent
    }
}