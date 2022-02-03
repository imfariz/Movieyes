package com.dicoding.movieyes.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.vo.Resource

class DetailShowViewModel(private val showRepository: ShowRepository) : ViewModel() {
    var showId = MutableLiveData<Int>()

    fun setSelectedShow(showId: Int) {
        this.showId.value = showId
    }

    var getMovie: LiveData<Resource<ShowEntity>> = Transformations.switchMap(showId) { mShowId ->
        showRepository.getMovieDetails(mShowId)
    }

    var getSerie: LiveData<Resource<ShowEntity>> = Transformations.switchMap(showId) { mShowId ->
        showRepository.getSerieDetails(mShowId)
    }

    fun setMovieBookmark() {
        val movieResource = getMovie.value
        if (movieResource != null) {
            val movie = movieResource.data

            if (movie != null) {
                val newState = !movie.bookmarked
                showRepository.setBookmark(movie, newState)
            }
        }
    }

    fun setSerieBookmark() {
        val serieResource = getSerie.value
        if (serieResource != null) {
            val serie = serieResource.data

            if (serie != null) {
                val newState = !serie.bookmarked
                showRepository.setBookmark(serie, newState)
            }
        }
    }
}