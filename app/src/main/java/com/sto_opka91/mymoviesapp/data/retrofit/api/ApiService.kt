package com.sto_opka91.mymoviesapp.data.retrofit.api

import com.sto_opka91.mymoviesapp.model.MovieModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers(
        value = ["X-API-KEY: af258a6b-5d9a-4423-8a2d-117035bb94a3",
            "Content-Type: application/json"])
    @GET("api/v2.2/films/top")
    suspend fun getPopularMovie(): Response<MovieModel>
}