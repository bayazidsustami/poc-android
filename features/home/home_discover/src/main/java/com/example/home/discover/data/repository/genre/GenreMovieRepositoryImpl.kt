package com.example.home.discover.data.repository.genre

import com.example.common.coroutine.qualifiers.IODispatcher
import com.example.home.discover.data.datasource.network.HomeDiscoverService
import com.example.home.discover.data.datasource.response.GenresResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class GenreMovieRepositoryImpl @Inject constructor(
    private val apiService: HomeDiscoverService,
    @IODispatcher
    private val dispatcher: CoroutineDispatcher
) : GenreMovieRepository {

    override fun getMovieGenres(): Flow<GenresResponse> {
        return flow {
            val result = apiService.getMovieGenre()
            emit(result)
        }.flowOn(dispatcher)
    }
}