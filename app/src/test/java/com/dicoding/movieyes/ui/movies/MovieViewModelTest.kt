package com.dicoding.movieyes.ui.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.utils.SortUtil
import com.dicoding.movieyes.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val sort = SortUtil.RANDOM

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<ShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(showRepository)
    }

    @Test
    fun loadMovies() {
        val dummyMovies = Resource.success(pagedList)
        `when`(dummyMovies.data?.size).thenReturn(5)
        val movies = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        movies.value = dummyMovies

        `when`(showRepository.getMovies(sort)).thenReturn(movies)
        val movieEntities = viewModel.getMovie(sort).value?.data
        verify(showRepository).getMovies(sort)
        assertNotNull(movieEntities)
        assertEquals(5, movieEntities?.size)

        viewModel.getMovie(sort).observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}