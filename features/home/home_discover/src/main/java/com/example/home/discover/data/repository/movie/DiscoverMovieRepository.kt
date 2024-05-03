package com.example.home.discover.data.repository.movie

import com.example.home.discover.data.datasource.response.DiscoverMovieResponse
import kotlinx.coroutines.flow.Flow

interface DiscoverMovieRepository {
    fun getDiscoverMovieByGenre(id:Int, page:Int): Flow<DiscoverMovieResponse>
}
