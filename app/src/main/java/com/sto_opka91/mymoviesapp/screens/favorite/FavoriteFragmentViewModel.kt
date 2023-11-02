package com.sto_opka91.mymoviesapp.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.sto_opka91.mymoviesapp.REALIZATION
import com.sto_opka91.mymoviesapp.data.room.repository.MoviesrepositoryRealization
import com.sto_opka91.mymoviesapp.model.Film

class FavoriteFragmentViewModel: ViewModel() {
    fun getAllMovies():LiveData<List<Film>>{
        return REALIZATION.allMovies
    }
}