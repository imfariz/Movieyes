package com.dicoding.movieyes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.movieyes.data.source.local.LocalDataSource
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.remote.RemoteDataSource
import com.dicoding.movieyes.utils.*
import com.dicoding.movieyes.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ShowRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local = mock(LocalDataSource::class.java)
    private val appExecutors = mock(AppExecutors::class.java)

    private val showRepository = FakeShowRepository(remote, local, appExecutors)

    private val movies = DataDummy.generateRemoteDetailsDummyMovies()
    private val series = DataDummy.generateRemoteDummySeries()
    private val movieBookmarks = DataDummy.generateMovieBookmarked()
    private val serieBookmarks = DataDummy.getSerieBookmarked()
    private val sort = SortUtil.RANDOM

    private val movieId = movies[0].id
    private val serieId = series[0].id

    @Test
    fun getAllMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getMovies(sort)).thenReturn(dataSourceFactory)
        showRepository.getMovies(sort)

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovies()))
        verify(local).getMovies(sort)
        assertNotNull(entities.data)
        assertEquals(movies.size.toLong(), entities.data?.size?.toLong())
    }

    @Test
    fun getAllTvShow() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getSeries(sort)).thenReturn(dataSourceFactory)
        showRepository.getSeries(sort)

        val entities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateSeries()))
        verify(local).getSeries(sort)
        assertNotNull(entities.data)
        assertEquals(series.size.toLong(), entities.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val dummyEntity = MutableLiveData<ShowEntity>()
        dummyEntity.value = DataDummy.generateMovies()[0]
        `when`(local.getDetailShow(movieId)).thenReturn(dummyEntity)

        val entities = LiveDataTestUtil.getValue(showRepository.getMovieDetails(movieId))
        verify(local).getDetailShow(movieId)
        assertNotNull(entities)
        assertNotNull(entities.data?.showId)
        assertNotNull(entities.data?.title)
        assertNotNull(entities.data?.overview)
        assertNotNull(entities.data?.release)
        assertNotNull(entities.data?.imagePath)
        assertNotNull(entities.data?.score)
        assertEquals(movies[0].id, entities.data?.showId)
        assertEquals(movies[0].title, entities.data?.title)
        assertEquals(movies[0].overview, entities.data?.overview)
        assertEquals(movies[0].releaseDate, entities.data?.release)
        assertEquals(
            movies[0].posterPath,
            entities.data?.imagePath
        )
        assertEquals(movies[0].voteAverage, entities.data!!.score, 0.0)
    }

    @Test
    fun getTVShowDetail() {
        val dummyEntity = MutableLiveData<ShowEntity>()
        dummyEntity.value = DataDummy.generateSeries()[0]
        `when`(local.getDetailShow(serieId)).thenReturn(dummyEntity)

        val entities = LiveDataTestUtil.getValue(showRepository.getSerieDetails(serieId))
        verify(local).getDetailShow(serieId)
        assertNotNull(entities)
        assertNotNull(entities.data?.showId)
        assertNotNull(entities.data?.title)
        assertNotNull(entities.data?.overview)
        assertNotNull(entities.data?.release)
        assertNotNull(entities.data?.imagePath)
        assertNotNull(entities.data?.score)
        assertEquals(series[0].id, entities.data?.showId)
        assertEquals(series[0].name, entities.data?.title)
        assertEquals(series[0].overview, entities.data?.overview)
        assertEquals(series[0].firstAirDate, entities.data?.release)
        assertEquals(
            series[0].posterPath,
            entities.data?.imagePath
        )
        assertEquals(series[0].voteAverage, entities.data!!.score, 0.0)
    }

    @Test
    fun getMovieBookmarks() {
        val dataSourceFactory = mock(DataSource.Factory::class.java) as DataSource.Factory<Int, ShowEntity>
        `when`(local.getMoviesBookmark()).thenReturn(dataSourceFactory)
        showRepository.getMoviesBookmark()

        val showEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateMovieBookmarked()))
        verify(local).getMoviesBookmark()
        assertNotNull(showEntities)
        assertEquals(movieBookmarks.size.toLong(), showEntities.data?.size?.toLong())
    }
}