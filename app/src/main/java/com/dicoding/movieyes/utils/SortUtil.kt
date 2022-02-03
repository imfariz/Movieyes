package com.dicoding.movieyes.utils

import androidx.sqlite.db.SimpleSQLiteQuery

object SortUtil {
    const val ASCENDING = "Ascending"
    const val DESCENDING = "Descending"
    const val RANDOM = "Random"

    fun getMoviesSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM showentities WHERE series=0 ")

        when (filter) {
            ASCENDING -> {
                simpleQuery.append("ORDER BY title DESC")
            }
            DESCENDING -> {
                simpleQuery.append("ORDER BY title ASC")
            }
            RANDOM -> {
                simpleQuery.append("ORDER BY RANDOM()")
            }
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }

    fun getSeriesSortedQuery(filter: String): SimpleSQLiteQuery {
        val simpleQuery = StringBuilder().append("SELECT * FROM showentities WHERE series=1 ")

        when (filter) {
            ASCENDING -> {
                simpleQuery.append("ORDER BY title DESC")
            }
            DESCENDING -> {
                simpleQuery.append("ORDER BY title ASC")
            }
            RANDOM -> {
                simpleQuery.append("ORDER BY RANDOM()")
            }
        }
        return SimpleSQLiteQuery(simpleQuery.toString())
    }
}