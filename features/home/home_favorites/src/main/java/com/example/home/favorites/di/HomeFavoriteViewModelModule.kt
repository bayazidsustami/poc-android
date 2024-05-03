package com.example.home.favorites.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.commons.components.viewmodel.ViewModelFactory
import com.example.commons.components.viewmodel.ViewModelKey
import com.example.home.favorites.presentation.viewmodel.MovieFavoriteViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = []
)
abstract class HomeFavoriteViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MovieFavoriteViewModel::class)
    internal abstract fun bindMovieFavorite(viewModel: MovieFavoriteViewModel): ViewModel

    @Binds
    @HomeFavorite
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}