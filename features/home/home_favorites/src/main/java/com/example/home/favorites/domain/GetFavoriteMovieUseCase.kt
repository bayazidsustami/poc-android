package com.example.home.favorites.domain

import com.example.home.favorites.data.repository.MovieFavoriteRepository
import com.example.home.favorites.domain.model.FavoriteMovieModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetFavoriteMovieUseCase @Inject constructor(
    private val repo: MovieFavoriteRepository
) {

    operator fun invoke(): Flow<List<FavoriteMovieModel>> {
        return repo.getMovieEntities().map { it.map { movies ->
            FavoriteMovieModel(movies.id, movies.title) } }
    }

}