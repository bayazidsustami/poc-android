package com.example.home.discover.data.repository.movie

import com.example.common.coroutine.qualifiers.IODispatcher
import com.example.home.discover.data.datasource.network.HomeDiscoverService
import com.example.home.discover.data.datasource.response.DiscoverMovieResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DiscoverMovieRepositoryImpl @Inject constructor(
    private val apiService: HomeDiscoverService,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher,
) : DiscoverMovieRepository {

    override fun getDiscoverMovieByGenre(id: Int, page: Int): Flow<DiscoverMovieResponse> {
        return flow {
            val result = apiService.getDiscoverMoviesByGenre(
                genreId = id,
                page = page
            )
            emit(result)
        }.flowOn(dispatcher)
    }
}