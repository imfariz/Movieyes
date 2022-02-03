package com.dicoding.movieyes.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @field:SerializedName("results")
    val results: List<ResultsMovies>
)

data class ResultsMovies(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("release_date")
    val releaseDate: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double
)
