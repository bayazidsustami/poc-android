package com.example.home.discover.di

import com.example.common.coroutine.DispatcherModule
import com.example.home.discover.data.datasource.HomeDiscoverDataSourceModule
import com.example.home.discover.data.repository.HomeDiscoverRepositoryModule
import com.example.home.discover.presentation.activity.HomeDiscoverActivity
import dagger.Component

@HomeDiscover
@Component(
    modules = [
        HomeDiscoverDataSourceModule::class,
        DispatcherModule::class,
        HomeDiscoverRepositoryModule::class,
        HomeDiscoverViewModelModule::class,
    ],
)
interface HomeDiscoverComponent {

    @Component.Factory
    interface Factory {
        fun create(): HomeDiscoverComponent
    }

    fun inject(activity: HomeDiscoverActivity)

}