package com.dicoding.movieyes.ui.bookmarks.content.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
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
class MoviesBookmarksViewModelTest {
    private lateinit var viewModel: MoviesBookmarksViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<PagedList<ShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<ShowEntity>

    @Before
    fun setup() {
        viewModel = MoviesBookmarksViewModel(showRepository)
    }

    @Test
    fun getMoviesBookmark() {
        val dummyMovies = pagedList
        `when`(dummyMovies.size).thenReturn(2)

        val movies = MutableLiveData<PagedList<ShowEntity>>()
        movies.value = dummyMovies

        `when`(showRepository.getMoviesBookmark()).thenReturn(movies)
        val showEntities = viewModel.getMoviesBookmark().value
        verify(showRepository).getMoviesBookmark()
        assertNotNull(showEntities)
        assertEquals(2, showEntities?.size)

        viewModel.getMoviesBookmark().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}