package com.example.home.discover.data.datasource

import com.example.home.discover.data.datasource.network.HomeDiscoverService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class HomeDiscoverDataSourceModule {

    @Provides
    fun provideHomeDiscoverService(retrofit: Retrofit): HomeDiscoverService {
        return retrofit.create(HomeDiscoverService::class.java)
    }

}