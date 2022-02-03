package com.dicoding.movieyes.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class SeriesResponse(
    @field:SerializedName("results")
    val results: List<SeriesItem>
)

data class SeriesItem(

    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("overview")
    val overview: String,

    @field:SerializedName("first_air_date")
    val firstAirDate: String,

    @field:SerializedName("poster_path")
    val posterPath: String,

    @field:SerializedName("vote_average")
    val voteAverage: Double
)
