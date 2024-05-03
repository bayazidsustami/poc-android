package com.example.home.discover.domain

import com.example.home.discover.data.repository.genre.GenreMovieRepository
import com.example.home.discover.data.repository.movie.DiscoverMovieRepository
import com.example.home.discover.domain.mapper.HomeMapper
import com.example.home.discover.domain.model.DiscoverMovieModelDomain
import com.example.home.discover.domain.model.GenreMovieModelDomain
import com.example.home.discover.domain.model.HomeModelDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetHomeContentUseCase @Inject constructor(
    private val genreRepo: GenreMovieRepository,
    private val movieRepo: DiscoverMovieRepository,
    private val homeMapper: HomeMapper,
) {

    operator fun invoke() : Flow<HomeModelDomain<List<GenreMovieModelDomain>, DiscoverMovieModelDomain>> {
        return genreRepo.getMovieGenres().flatMapConcat { genre ->
            val firstGenre = genre.genres.firstOrNull()?.id ?: 0
            return@flatMapConcat movieRepo
                .getDiscoverMovieByGenre(firstGenre, 1)
                .map { discover ->
                    HomeModelDomain(
                        genres = homeMapper.mapGenreResponseToDomain(genre),
                        movies = homeMapper.mapDiscoverResponseToDomain(discover)
                    )
                }
        }
    }

}