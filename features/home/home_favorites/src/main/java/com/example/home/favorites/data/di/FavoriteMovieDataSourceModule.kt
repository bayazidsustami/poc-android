package com.example.home.favorites.data.di

import com.example.datasource.local.di.DatabaseModule
import com.example.home.favorites.data.repository.MovieFavoriteRepository
import com.example.home.favorites.data.repository.MovieFavoriteRepositoryImpl
import com.example.home.favorites.di.HomeFavorite
import dagger.Binds
import dagger.Module

@Module(
    includes = [DatabaseModule::class]
)
internal abstract class FavoriteMovieDataSourceModule {

    @Binds
    @HomeFavorite
    abstract fun bindFavoriteMovieRepository(repository: MovieFavoriteRepositoryImpl): MovieFavoriteRepository
}