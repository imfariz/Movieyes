package com.dicoding.movieyes.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.utils.DataDummy
import com.dicoding.movieyes.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTVShowViewModelTest {
    private lateinit var viewModel: DetailShowViewModel
    private val dummySerie = DataDummy.generateDummyMovies()[11]
    private val serieId = dummySerie.showId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var showRepository: ShowRepository

    @Mock
    private lateinit var observer: Observer<Resource<ShowEntity>>

    @Before
    fun setup() {
        viewModel = DetailShowViewModel(showRepository)
    }

    @Test
    fun getDetailsTvShow() {
        val series = MutableLiveData<Resource<ShowEntity>>()
        val serie = Resource.success(dummySerie)
        series.value = serie
        `when`(showRepository.getSerieDetails(serieId)).thenReturn(series)

        viewModel.setSelectedShow(serieId)
        viewModel.getSerie.observeForever(observer)
        verify(showRepository).getSerieDetails(serieId)
        verify(observer).onChanged(serie)
    }
}