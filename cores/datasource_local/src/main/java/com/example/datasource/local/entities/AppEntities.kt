package com.example.datasource.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "app_entity")
data class AppEntities(
    @PrimaryKey
    val name: String,

    @ColumnInfo(name = "version")
    val version: String
)
