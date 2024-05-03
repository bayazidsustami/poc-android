package com.example.home.discover.presentation.viewmodel

import com.example.home.discover.domain.model.DiscoverMovieModelDomain
import com.example.home.discover.domain.model.GenreMovieModelDomain
import com.example.home.discover.domain.model.HomeModelDomain

sealed class HomeDiscoverUIEvent {
    data object Loading: HomeDiscoverUIEvent()

    data class Success(val data: HomeModelDomain<List<GenreMovieModelDomain>, DiscoverMovieModelDomain>): HomeDiscoverUIEvent()

    data class Failed(val message: String): HomeDiscoverUIEvent()
}
