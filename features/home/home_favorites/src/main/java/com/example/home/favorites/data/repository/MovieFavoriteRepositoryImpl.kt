package com.example.home.favorites.data.repository

import com.example.datasource.local.dao.movies.FavoriteMovieDao
import com.example.datasource.local.entities.movies.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MovieFavoriteRepositoryImpl @Inject constructor(
    private val favMovieDao: FavoriteMovieDao
) : MovieFavoriteRepository{
    override fun getMovieEntities(): Flow<List<FavoriteMovieEntity>> {
        return favMovieDao.getFavMovie()
    }
}