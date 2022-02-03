package com.dicoding.movieyes.ui.bookmarks

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.dicoding.movieyes.R
import com.dicoding.movieyes.ui.bookmarks.content.movie.BookmarksMovieFragment
import com.dicoding.movieyes.ui.bookmarks.content.serie.BookmarksSerieFragment

class BookmarksPagerAdapter(fm: FragmentManager, private val context: Context) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int = TAB_TITLES.size

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> BookmarksMovieFragment()
            1 -> BookmarksSerieFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movie, R.string.tv_show)
    }
}