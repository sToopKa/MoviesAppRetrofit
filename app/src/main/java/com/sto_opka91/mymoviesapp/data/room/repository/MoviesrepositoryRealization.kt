package com.sto_opka91.mymoviesapp.data.room.repository

import androidx.lifecycle.LiveData
import com.sto_opka91.mymoviesapp.data.room.dao.MoviesDao
import com.sto_opka91.mymoviesapp.model.Film

class MoviesrepositoryRealization(private val moviesDao: MoviesDao): MoviesRepository {
    override val allMovies: LiveData<List<Film>>
        get() = moviesDao.getAllMovies()

    override suspend fun insertMovie(film: Film, onSuccsess: () -> Unit) {
        moviesDao.insert(film)
        onSuccsess()
    }

    override suspend fun deleteMovie(film: Film, onSuccsess: () -> Unit) {
        moviesDao.delete(film)
        onSuccsess()
    }
}