package com.example.home.favorites.data.repository

import com.example.datasource.local.entities.movies.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow

interface MovieFavoriteRepository {
    fun getMovieEntities() : Flow<List<FavoriteMovieEntity>>
}