package com.dicoding.movieyes.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.utils.SortUtil
import com.dicoding.movieyes.vo.Resource
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
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
        viewModel = TvShowViewModel(showRepository)
    }

    @Test
    fun loadTvSeries() {
        val dummySeries = Resource.success(pagedList)
        `when`(dummySeries.data?.size).thenReturn(5)
        val series = MutableLiveData<Resource<PagedList<ShowEntity>>>()
        series.value = dummySeries

        `when`(showRepository.getSeries(sort)).thenReturn(series)
        val serieEntities = viewModel.getSeries(sort).value?.data
        Mockito.verify(showRepository).getSeries(sort)
        assertNotNull(serieEntities)
        assertEquals(5, serieEntities?.size)

        viewModel.getSeries(sort).observeForever(observer)
        verify(observer).onChanged(dummySeries)
    }
}