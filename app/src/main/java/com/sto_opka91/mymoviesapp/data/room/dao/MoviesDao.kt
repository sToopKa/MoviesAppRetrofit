package com.sto_opka91.mymoviesapp.data.room.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.sto_opka91.mymoviesapp.model.Film

@Dao
interface MoviesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(film: Film)
    @Delete
    suspend fun delete(film: Film)
    @Transaction
    @Query("SELECT * FROM movie_table")
    fun getAllMovies():LiveData<List<Film>>
}