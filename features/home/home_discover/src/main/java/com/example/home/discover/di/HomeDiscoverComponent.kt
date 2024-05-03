package com.example.home.discover.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.common.coroutine.DispatcherModule
import com.example.core.applications.AppComponent
import com.example.core.network.di.NetworkComponent
import com.example.core.network.di.NetworkModule
import com.example.home.discover.data.datasource.HomeDiscoverDataSourceModule
import com.example.home.discover.data.repository.HomeDiscoverRepositoryModule
import com.example.home.discover.presentation.activity.HomeDiscoverActivity
import dagger.BindsInstance
import dagger.Component

@HomeDiscover
@Component(
    modules = [
        HomeDiscoverDataSourceModule::class,
        DispatcherModule::class,
        HomeDiscoverRepositoryModule::class,
        HomeDiscoverViewModelModule::class,
    ],
    dependencies = [
        AppComponent::class,
    ]
)
interface HomeDiscoverComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): HomeDiscoverComponent
    }

    fun inject(activity: HomeDiscoverActivity)

}