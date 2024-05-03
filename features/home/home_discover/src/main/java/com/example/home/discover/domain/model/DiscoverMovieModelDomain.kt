package com.example.home.discover.domain.model

data class DiscoverMovieModelDomain(
    val page: Int = 1,
    val totalPages: Int = 0,
    val results: List<MovieItem> = emptyList(),
    val totalResults: Int = 0
) {
    data class MovieItem(
        val id: Int = 0,
        val overview: String = "",
        val title: String = "",
        val genreIds: List<Int> = emptyList(),
        val posterPath: String = "",
        val releaseDate: String = "",
        val popularity: Double = 0.0,
        val voteAverage: Double= 0.0,
        val voteCount: Int = 0

    )
}
