package com.dicoding.movieyes.data

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.movieyes.data.source.ShowsDataSource
import com.dicoding.movieyes.data.source.local.LocalDataSource
import com.dicoding.movieyes.data.source.local.entity.ShowEntity
import com.dicoding.movieyes.data.source.remote.ApiResponse
import com.dicoding.movieyes.data.source.remote.RemoteDataSource
import com.dicoding.movieyes.data.source.remote.response.ResultsMovies
import com.dicoding.movieyes.data.source.remote.response.SeriesItem
import com.dicoding.movieyes.utils.AppExecutors
import com.dicoding.movieyes.vo.Resource

class FakeShowRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    ShowsDataSource {

    override fun getMovies(sort: String): LiveData<Resource<PagedList<ShowEntity>>> {
        return object : NetworkBoundResource<PagedList<ShowEntity>, List<ResultsMovies>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<ResultsMovies>>> =
                remoteDataSource.getMovies()

            public override fun saveCallResult(data: List<ResultsMovies>) {
                val movieList = ArrayList<ShowEntity>()
                for (response in data) {
                    val movie = ShowEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.releaseDate,
                        "https://image.tmdb.org/t/p/original" + response.posterPath,
                        response.voteAverage,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertShow(movieList)
            }
        }.asLiveData()
    }

    override fun getSeries(sort: String): LiveData<Resource<PagedList<ShowEntity>>> {
        return object : NetworkBoundResource<PagedList<ShowEntity>, List<SeriesItem>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<ShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getSeries(sort), config).build()
            }

            override fun shouldFetch(data: PagedList<ShowEntity>?): Boolean =
                data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<SeriesItem>>> =
                remoteDataSource.getSeries()

            public override fun saveCallResult(data: List<SeriesItem>) {
                val seriesList = ArrayList<ShowEntity>()
                for (response in data) {
                    val serie = ShowEntity(
                        response.id,
                        response.name,
                        response.overview,
                        response.firstAirDate,
                        "https://image.tmdb.org/t/p/original" + response.posterPath,
                        response.voteAverage,
                        true
                    )
                    seriesList.add(serie)
                }

                localDataSource.insertShow(seriesList)
            }
        }.asLiveData()
    }

    override fun getMovieDetails(showId: Int): LiveData<Resource<ShowEntity>> {
        return object : NetworkBoundResource<ShowEntity, List<ResultsMovies>>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowEntity> = localDataSource.getDetailShow(showId)

            override fun shouldFetch(data: ShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<List<ResultsMovies>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<ResultsMovies>) {
                val movieList = ArrayList<ShowEntity>()
                for (response in data) {
                    val movie = ShowEntity(
                        response.id,
                        response.title,
                        response.overview,
                        response.releaseDate,
                        "https://image.tmdb.org/t/p/original" + response.posterPath,
                        response.voteAverage,
                        false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertShow(movieList)
            }
        }.asLiveData()
    }

    override fun getSerieDetails(showId: Int): LiveData<Resource<ShowEntity>> {
        return object : NetworkBoundResource<ShowEntity, List<SeriesItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<ShowEntity> = localDataSource.getDetailShow(showId)

            override fun shouldFetch(data: ShowEntity?): Boolean = data == null

            override fun createCall(): LiveData<ApiResponse<List<SeriesItem>>> =
                remoteDataSource.getSeries()

            override fun saveCallResult(data: List<SeriesItem>) {
                val movieList = ArrayList<ShowEntity>()
                for (response in data) {
                    val movie = ShowEntity(
                        response.id,
                        response.name,
                        response.overview,
                        response.firstAirDate,
                        "https://image.tmdb.org/t/p/original" + response.posterPath,
                        response.voteAverage,
                        true
                    )
                    movieList.add(movie)
                }

                localDataSource.insertShow(movieList)
            }
        }.asLiveData()
    }

    override fun getMoviesBookmark(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getMoviesBookmark(), config).build()
    }

    override fun getTvShowBookmark(): LiveData<PagedList<ShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getTvShowBookmark(), config).build()
    }

    override fun setBookmark(show: ShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavorite(show, state) }
    }
}