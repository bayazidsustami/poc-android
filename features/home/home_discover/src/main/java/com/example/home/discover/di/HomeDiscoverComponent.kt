package com.example.home.discover.di

import com.example.common.coroutine.DispatcherModule
import com.example.core.network.di.NetworkComponent
import com.example.home.discover.data.datasource.HomeDiscoverDataSourceModule
import com.example.home.discover.data.repository.HomeDiscoverRepositoryModule
import dagger.Component

@HomeDiscover
@Component(
    modules = [
        HomeDiscoverDataSourceModule::class,
        DispatcherModule::class,
        HomeDiscoverRepositoryModule::class,
    ],
    dependencies = [
        NetworkComponent::class
    ]
)
interface HomeDiscoverComponent {

    @Component.Factory
    interface Factory {
        fun create(networkComponent: NetworkComponent): HomeDiscoverComponent
    }

}