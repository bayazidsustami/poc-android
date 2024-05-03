package com.example.home.discover.data.repository.genre

import com.example.home.discover.data.datasource.response.GenresResponse
import kotlinx.coroutines.flow.Flow

interface GenreMovieRepository {
    fun getMovieGenres(): Flow<GenresResponse>
}
