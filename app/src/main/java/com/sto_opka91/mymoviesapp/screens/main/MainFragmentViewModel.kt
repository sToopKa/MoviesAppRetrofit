package com.sto_opka91.mymoviesapp.screens.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.sto_opka91.mymoviesapp.REALIZATION
import com.sto_opka91.mymoviesapp.data.MoviesRoomDB
import com.sto_opka91.mymoviesapp.data.retrofit.repository.RetrofitRepository
import com.sto_opka91.mymoviesapp.data.room.repository.MoviesrepositoryRealization
import com.sto_opka91.mymoviesapp.model.MovieModel
import kotlinx.coroutines.launch
import retrofit2.Response

class MainFragmentViewModel(application: Application): AndroidViewModel(application) {
    private val repository = RetrofitRepository()

    var myMovie: MutableLiveData<Response<MovieModel>> = MutableLiveData()
    private val context = application
    fun getMoviesRetrofit(){
        viewModelScope.launch {
            try{
                myMovie.value = repository.getMovies()
            } catch(e: Exception){
                Log.e("myLog", "${e.message}")
            }
        }
    }
    fun initDatabase(){

            val daoMovie = MoviesRoomDB.getInstance(context).getMovieDao()
            REALIZATION = MoviesrepositoryRealization(daoMovie)
    }

}