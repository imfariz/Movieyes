package com.dicoding.movieyes.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery
import com.dicoding.movieyes.data.source.local.entity.ShowEntity

@Dao
interface ShowDao {

    @RawQuery(observedEntities = [ShowEntity::class])
    fun getMovies(query: SupportSQLiteQuery) : DataSource.Factory<Int, ShowEntity>

    @RawQuery(observedEntities = [ShowEntity::class])
    fun getSeries(query: SupportSQLiteQuery) : DataSource.Factory<Int, ShowEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShow(show: List<ShowEntity>)

    @Transaction
    @Query("SELECT * FROM showentities WHERE showId = :showId")
    fun getDetails(showId: Int): LiveData<ShowEntity>

    @Query("SELECT * FROM showentities WHERE series = 0 AND bookmarked = 1 ")
    fun getMoviesBookmark(): DataSource.Factory<Int, ShowEntity>

    @Query("SELECT * FROM showentities WHERE series = 1 AND bookmarked = 1 ")
    fun getTvshowsBookmark(): DataSource.Factory<Int, ShowEntity>

    @Update
    fun updateBookmark(show: ShowEntity)
}