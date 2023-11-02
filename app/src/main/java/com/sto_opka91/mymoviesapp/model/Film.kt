package com.sto_opka91.mymoviesapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "movie_table")
data class Film(
    @PrimaryKey(autoGenerate = true)
    val filmId: Int,

    val nameRu: String,

    val posterUrl: String,

    val rating: String,

    val year: String
) : Serializable