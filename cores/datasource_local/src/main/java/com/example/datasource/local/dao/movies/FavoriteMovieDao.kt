package com.example.datasource.local.dao.movies

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.datasource.local.entities.movies.FavoriteMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteMovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovie(favMovie: FavoriteMovieEntity)

    @Query("SELECT id, title FROM favorite_movies")
    fun getFavMovie(): Flow<List<FavoriteMovieEntity>>

}