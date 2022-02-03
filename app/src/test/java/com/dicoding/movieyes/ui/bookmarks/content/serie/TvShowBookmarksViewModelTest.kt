package com.dicoding.movieyes.ui.bookmarks.content.serie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowBookmarksViewModelTest {
    private lateinit var viewModel: TvShowBookmarksViewModel

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
        viewModel = TvShowBookmarksViewModel(showRepository)
    }

    @Test
    fun getTvShowBookmark() {
        val dummyTv = pagedList
        Mockito.`when`(dummyTv.size).thenReturn(2)

        val tv = MutableLiveData<PagedList<ShowEntity>>()
        tv.value = dummyTv

        Mockito.`when`(showRepository.getTvShowBookmark()).thenReturn(tv)
        val showEntities = viewModel.getTvShowBookmark().value
        Mockito.verify(showRepository).getTvShowBookmark()
        assertNotNull(showEntities)
        assertEquals(2, showEntities?.size)

        viewModel.getTvShowBookmark().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }
}