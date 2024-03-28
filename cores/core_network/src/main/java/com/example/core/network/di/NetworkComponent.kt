package com.example.core.network.di

import com.example.core.applications.AppModule
import dagger.Component

@Component(
    modules = [NetworkModule::class, AppModule::class])
interface NetworkComponent {
    @Component.Factory
    interface Factory{
        fun create(): NetworkComponent
    }
}