package com.sto_opka91.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.sto_opka91.mymoviesapp.model.Film

interface MoviesRepository {
    val allMovies: LiveData<List<Film>>
    suspend fun insertMovie(film:Film, onSuccsess:() ->Unit)
    suspend fun deleteMovie(film:Film, onSuccsess:() ->Unit)

}