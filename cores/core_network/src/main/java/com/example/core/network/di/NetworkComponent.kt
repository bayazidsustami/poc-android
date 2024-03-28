package com.example.core.network.di

import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    @Component.Factory
    interface Factory{
        fun create(): NetworkComponent
    }
}