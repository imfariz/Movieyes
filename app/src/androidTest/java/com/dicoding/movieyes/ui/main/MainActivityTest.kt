package com.dicoding.movieyes.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.dicoding.movieyes.R
import com.dicoding.movieyes.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainActivityTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(MainActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.navigation_movie)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7)
        )
    }

    @Test
    fun loadSeries() {
        onView(withId(R.id.navigation_series)).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(8)
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.navigation_movie)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(7)
        )
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(6, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTVShow() {
        onView(withId(R.id.navigation_series)).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun addRemoveMovieBookmarks() {
        onView(withId(R.id.navigation_movie)).perform(click())
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_bookmarks)).perform(click())
        onView(withId(R.id.rv_bookmarks_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmarks_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.tv_bm_movie)).check(matches(isDisplayed()))
    }

    @Test
    fun addRemoveTVShowBookmarks() {
        onView(withId(R.id.navigation_series)).perform(click())
        onView(withId(R.id.rv_series)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_series)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.navigation_bookmarks)).perform(click())
        onView(withText("SERIES")).perform(click())
        onView(withId(R.id.rv_bookmarks_serie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_bookmarks_serie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )

        onView(withId(R.id.show_title)).check(matches(isDisplayed()))
        onView(withId(R.id.release)).check(matches(isDisplayed()))
        onView(withId(R.id.score)).check(matches(isDisplayed()))
        onView(withId(R.id.overview)).check(matches(isDisplayed()))
        onView(withId(R.id.show_poster)).check(matches(isDisplayed()))

        onView(withId(R.id.action_bookmark)).perform(click())
        onView(isRoot()).perform(ViewActions.pressBack())
        onView(withId(R.id.tv_bm_serie)).check(matches(isDisplayed()))
    }
}