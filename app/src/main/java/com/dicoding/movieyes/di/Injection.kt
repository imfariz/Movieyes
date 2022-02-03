package com.dicoding.movieyes.di

import android.content.Context
import com.dicoding.movieyes.data.source.ShowRepository
import com.dicoding.movieyes.data.source.local.LocalDataSource
import com.dicoding.movieyes.data.source.local.room.ShowDatabase
import com.dicoding.movieyes.data.source.remote.RemoteDataSource
import com.dicoding.movieyes.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): ShowRepository {

        val database = ShowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.showDao())
        val appExecutors = AppExecutors()

        return ShowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}