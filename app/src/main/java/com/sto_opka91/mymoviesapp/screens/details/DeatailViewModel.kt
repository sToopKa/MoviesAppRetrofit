package com.sto_opka91.mymoviesapp.screens.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sto_opka91.mymoviesapp.REALIZATION
import com.sto_opka91.mymoviesapp.data.room.repository.MoviesrepositoryRealization
import com.sto_opka91.mymoviesapp.model.Film
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DeatailViewModel: ViewModel() {

    fun insertToTable(film:Film, onSuccess:()-> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.insertMovie(film){
                onSuccess()
            }
        }
    fun deleteFromTable(film:Film, onSuccess:()-> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REALIZATION.deleteMovie(film){
                onSuccess()
            }
        }
}