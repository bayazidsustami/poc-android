package com.example.home.discover.data.repository

import com.example.common.coroutine.DispatcherModule
import com.example.home.discover.data.repository.genre.GenreMovieRepository
import com.example.home.discover.data.repository.genre.GenreMovieRepositoryImpl
import com.example.home.discover.data.repository.movie.DiscoverMovieRepository
import com.example.home.discover.data.repository.movie.DiscoverMovieRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(
    includes = [
        DispatcherModule::class
    ]
)
abstract class HomeDiscoverRepositoryModule {

    @Binds
    abstract fun bindMovieDiscoverRepository(repository: DiscoverMovieRepositoryImpl): DiscoverMovieRepository

    @Binds
    abstract fun bindMovieGenre(repository: GenreMovieRepositoryImpl): GenreMovieRepository

}