package com.dicoding.movieyes.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.vo.Resource

class TvShowViewModel(private val showRepository: ShowRepository) : ViewModel() {
    fun getSeries(sort: String): LiveData<Resource<PagedList<ShowEntity>>> = showRepository.getSeries(sort)
}