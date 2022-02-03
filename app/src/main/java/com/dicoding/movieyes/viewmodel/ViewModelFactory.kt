package com.dicoding.movieyes.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.di.Injection
import com.dicoding.movieyes.ui.bookmarks.content.movie.MoviesBookmarksViewModel
import com.dicoding.movieyes.ui.bookmarks.content.serie.TvShowBookmarksViewModel
import com.dicoding.movieyes.ui.detail.DetailShowViewModel
import com.dicoding.movieyes.ui.movies.MovieViewModel
import com.dicoding.movieyes.ui.tv.TvShowViewModel

class ViewModelFactory private constructor(private val mShowRepository: ShowRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(MoviesBookmarksViewModel::class.java) -> {
                MoviesBookmarksViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(TvShowBookmarksViewModel::class.java) -> {
                TvShowBookmarksViewModel(mShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailShowViewModel::class.java) -> {
                DetailShowViewModel(mShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }
}