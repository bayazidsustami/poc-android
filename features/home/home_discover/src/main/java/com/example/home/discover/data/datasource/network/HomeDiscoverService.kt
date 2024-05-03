package com.example.home.discover.data.datasource.network

import com.example.home.discover.data.datasource.response.DiscoverMovieResponse
import com.example.home.discover.data.datasource.response.GenresResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeDiscoverService {
    @GET("genre/movie/list")
    suspend fun getMovieGenre() : GenresResponse

    @GET("discover/movie")
    suspend fun getDiscoverMoviesByGenre(
        @Query("with_genres") genreId: Int,
        @Query("page") page:Int,
        @Query("sort_by") sortBy: String = "popularity.desc",
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("include_video") includeVideo: Boolean = false,
    ): DiscoverMovieResponse

}