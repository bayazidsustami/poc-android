package com.example.home.discover.data.datasource

import com.example.core.network.di.NetworkModule
import com.example.home.discover.data.datasource.network.HomeDiscoverService
import com.example.home.discover.di.HomeDiscover
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module(includes = [
    NetworkModule::class,
])
class HomeDiscoverDataSourceModule {

    @Provides
    @HomeDiscover
    fun provideHomeDiscoverService(retrofit: Retrofit): HomeDiscoverService {
        return retrofit.create(HomeDiscoverService::class.java)
    }

}