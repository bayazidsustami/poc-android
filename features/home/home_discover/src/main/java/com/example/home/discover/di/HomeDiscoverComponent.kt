package com.example.home.discover.di

import com.example.commons.components.activity.di.BaseActivityComponent
import com.example.home.discover.data.datasource.HomeDiscoverDataSourceModule
import com.example.home.discover.data.repository.HomeDiscoverRepositoryModule
import com.example.home.discover.presentation.activity.HomeDiscoverActivity
import dagger.Component

@HomeDiscover
@Component(
    modules = [
        HomeDiscoverDataSourceModule::class,
        HomeDiscoverRepositoryModule::class,
        HomeDiscoverViewModelModule::class,
    ],
    dependencies = [
        BaseActivityComponent::class,
    ]
)
interface HomeDiscoverComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: BaseActivityComponent): HomeDiscoverComponent
    }

    fun inject(activity: HomeDiscoverActivity)

}