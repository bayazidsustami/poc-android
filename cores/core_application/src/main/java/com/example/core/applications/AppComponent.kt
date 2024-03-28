package com.example.core.applications

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder{
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}