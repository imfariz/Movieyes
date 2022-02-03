package com.dicoding.movieyes.utils.api

import com.dicoding.movieyes.data.source.remote.response.MoviesResponse
import com.dicoding.movieyes.data.source.remote.response.SeriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Call<MoviesResponse>

    @GET("discover/tv")
    fun getSeries(@Query("api_key") api_key: String): Call<SeriesResponse>
}