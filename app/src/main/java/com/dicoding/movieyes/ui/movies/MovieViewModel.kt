package com.dicoding.movieyes.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.vo.Resource

class MovieViewModel(private val showRepository: ShowRepository) : ViewModel() {
    fun getMovie(sort: String): LiveData<Resource<PagedList<ShowEntity>>> = showRepository.getMovies(sort)
}