package com.dicoding.movieyes.data.source.remote

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.movieyes.data.source.remote.response.MoviesResponse
import com.dicoding.movieyes.data.source.remote.response.ResultsMovies
import com.dicoding.movieyes.data.source.remote.response.SeriesItem
import com.dicoding.movieyes.data.source.remote.response.SeriesResponse
import com.dicoding.movieyes.utils.EspressoIdlingResource
import com.dicoding.movieyes.utils.api.ApiConfig
import retrofit2.Call
import retrofit2.Response

class RemoteDataSource private constructor() {

    fun getMovies(): LiveData<ApiResponse<List<ResultsMovies>>> {
        EspressoIdlingResource.increment()
        val movies = MutableLiveData<ApiResponse<List<ResultsMovies>>>()
        val client = ApiConfig.getApiService().getMovies("e67cc6b698ecb36582beaead768a15ae")
        client.enqueue(object : retrofit2.Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                if (response.body() != null) {
                    movies.value = ApiResponse.success(response.body()!!.results)
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("Feedback", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return movies
    }

    fun getSeries(): LiveData<ApiResponse<List<SeriesItem>>> {
        EspressoIdlingResource.increment()
        val series = MutableLiveData<ApiResponse<List<SeriesItem>>>()
        val client = ApiConfig.getApiService().getSeries("e67cc6b698ecb36582beaead768a15ae")
        client.enqueue(object : retrofit2.Callback<SeriesResponse> {
            override fun onResponse(
                call: Call<SeriesResponse>,
                response: Response<SeriesResponse>
            ) {
                if (response.body() != null) {
                    series.value = ApiResponse.success(response.body()!!.results)
                } else {
                    Log.e(ContentValues.TAG, "onFailure: ${response.message()}")
                }
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<SeriesResponse>, t: Throwable) {
                Log.e("Feedback", "onFailure: ${t.message.toString()}")
                EspressoIdlingResource.decrement()
            }
        })
        return series
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }
}