package com.sto_opka91.mymoviesapp.data.retrofit.repository

import com.sto_opka91.mymoviesapp.data.retrofit.api.RetrofitInstance
import com.sto_opka91.mymoviesapp.model.MovieModel
import retrofit2.Response

class RetrofitRepository {
    suspend fun getMovies():Response<MovieModel>{
        return RetrofitInstance.api.getPopularMovie()
    }
}