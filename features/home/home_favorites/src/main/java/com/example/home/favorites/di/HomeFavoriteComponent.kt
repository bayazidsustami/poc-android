package com.example.home.favorites.di

import com.example.common.coroutine.DispatcherModule
import com.example.core.applications.AppComponent
import com.example.home.favorites.data.di.FavoriteMovieDataSourceModule
import com.example.home.favorites.presentation.activity.MovieFavoriteActivity
import dagger.Component

@Component(
    dependencies = [
        AppComponent::class,
    ],
    modules = [
        HomeFavoriteViewModelModule::class,
        FavoriteMovieDataSourceModule::class,
        DispatcherModule::class,
    ]
)
@HomeFavorite
interface HomeFavoriteComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: AppComponent): HomeFavoriteComponent
    }

    fun inject(activity: MovieFavoriteActivity)
}