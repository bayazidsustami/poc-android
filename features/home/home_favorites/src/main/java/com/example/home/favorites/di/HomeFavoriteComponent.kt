package com.example.home.favorites.di

import android.content.Context
import com.example.commons.components.activity.di.BaseActivityComponent
import com.example.home.favorites.data.di.FavoriteMovieDataSourceModule
import com.example.home.favorites.presentation.activity.MovieFavoriteActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [
        BaseActivityComponent::class,
    ],
    modules = [
        HomeFavoriteViewModelModule::class,
        FavoriteMovieDataSourceModule::class,
    ]
)
@HomeFavorite
interface HomeFavoriteComponent {

    @Component.Factory
    interface Factory {
        fun create(appComponent: BaseActivityComponent, @BindsInstance context: Context): HomeFavoriteComponent
    }

    fun inject(activity: MovieFavoriteActivity)
}