package com.example.home.discover.domain.mapper

import com.example.home.discover.data.datasource.response.DiscoverMovieResponse
import com.example.home.discover.data.datasource.response.GenresResponse
import com.example.home.discover.domain.model.DiscoverMovieModelDomain
import com.example.home.discover.domain.model.GenreMovieModelDomain
import javax.inject.Inject

class HomeMapper @Inject constructor() {

    fun mapGenreResponseToDomain(response: GenresResponse): List<GenreMovieModelDomain> {
        return response.genres.map {
            GenreMovieModelDomain(
                id = it.id ?: 0,
                name = it.name ?: ""
            )
        }
    }

    fun mapDiscoverResponseToDomain(response: DiscoverMovieResponse): DiscoverMovieModelDomain {
        return DiscoverMovieModelDomain(
            page = response.page ?: 0,
            totalPages = response.totalPages ?: 0,
            totalResults = response.totalResults ?: 0,
            results = response.results.map {
                DiscoverMovieModelDomain.MovieItem(
                    id = it.id ?: 0,
                    overview = it.overview ?: "",
                    title = it.title ?: "",
                    genreIds = it.genreIds ?: emptyList(),
                    posterPath = it.posterPath ?: "",
                    releaseDate = it.releaseDate ?: "",
                    popularity = it.popularity ?: 0.0,
                    voteAverage = it.voteAverage ?: 0.0,
                    voteCount = it.voteCount ?: 0,
                )
            },
        )
    }


}