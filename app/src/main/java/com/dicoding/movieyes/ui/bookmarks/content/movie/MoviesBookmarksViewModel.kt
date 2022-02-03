package com.dicoding.movieyes.ui.bookmarks.content.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity

class MoviesBookmarksViewModel(private val showRepository: ShowRepository) : ViewModel() {

    fun getMoviesBookmark(): LiveData<PagedList<ShowEntity>> =
        showRepository.getMoviesBookmark()
}