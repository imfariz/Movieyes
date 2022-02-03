package com.dicoding.movieyes.ui.bookmarks.content.serie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity

class TvShowBookmarksViewModel(private val showRepository: ShowRepository): ViewModel() {

    fun getTvShowBookmark(): LiveData<PagedList<ShowEntity>> =
        showRepository.getTvShowBookmark()
}