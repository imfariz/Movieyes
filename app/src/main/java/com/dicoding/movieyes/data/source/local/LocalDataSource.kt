package com.dicoding.movieyes.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.local.room.ShowDao
import com.dicoding.movieyes.utils.SortUtil

class LocalDataSource private constructor(private val mShowDao: ShowDao) {

    fun getMovies(sort: String): DataSource.Factory<Int, ShowEntity> {
        val query = SortUtil.getMoviesSortedQuery(sort)
        return mShowDao.getMovies(query)
    }

    fun getSeries(sort: String): DataSource.Factory<Int, ShowEntity> {
        val query = SortUtil.getSeriesSortedQuery(sort)
        return mShowDao.getSeries(query)
    }

    fun getMoviesBookmark(): DataSource.Factory<Int, ShowEntity> = mShowDao.getMoviesBookmark()

    fun getTvShowBookmark(): DataSource.Factory<Int, ShowEntity> = mShowDao.getTvshowsBookmark()

    fun insertShow(show: List<ShowEntity>) = mShowDao.insertShow(show)

    fun getDetailShow(showId : Int) = mShowDao.getDetails(showId)

    fun setFavorite(show: ShowEntity, state: Boolean) {
        show.bookmarked = state
        mShowDao.updateBookmark(show)
    }

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(showDao: ShowDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(showDao)
    }

}