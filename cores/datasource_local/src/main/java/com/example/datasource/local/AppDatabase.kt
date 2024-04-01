package com.example.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datasource.local.dao.AppDao
import com.example.datasource.local.dao.movies.FavoriteMovieDao
import com.example.datasource.local.entities.AppEntities
import com.example.datasource.local.entities.movies.FavoriteMovieEntity


@Database(entities = [
        AppEntities::class,
        FavoriteMovieEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appDao(): AppDao

    abstract fun favoriteMovieDao(): FavoriteMovieDao
}