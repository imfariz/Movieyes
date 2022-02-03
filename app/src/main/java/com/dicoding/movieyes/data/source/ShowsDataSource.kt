package com.dicoding.movieyes.data.source

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.vo.Resource

interface ShowsDataSource {
    fun getMovies(sort: String): LiveData<Resource<PagedList<ShowEntity>>>
    fun getSeries(sort: String): LiveData<Resource<PagedList<ShowEntity>>>
    fun getMovieDetails(showId: Int): LiveData<Resource<ShowEntity>>
    fun getSerieDetails(showId: Int): LiveData<Resource<ShowEntity>>
    fun getMoviesBookmark(): LiveData<PagedList<ShowEntity>>
    fun getTvShowBookmark(): LiveData<PagedList<ShowEntity>>
    fun setBookmark(show: ShowEntity, state: Boolean)
}