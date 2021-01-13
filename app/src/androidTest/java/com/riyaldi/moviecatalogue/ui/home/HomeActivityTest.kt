package com.riyaldi.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.riyaldi.moviecatalogue.R
import com.riyaldi.moviecatalogue.utils.DataDummy
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.getMovies()
    private val dummyTvShow = DataDummy.getTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail)).check(matches(withTagValue(equalTo(dummyMovie[0].poster))))
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.collapsing)).check(matches(withContentDescription(dummyMovie[0].title)))
        onView(withId(R.id.tv_detail_genre_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_duration)).check(matches(withText("${dummyMovie[0].genre} | ${dummyMovie[0].duration}")))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyMovie[0].overview)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.iv_detail)).check(matches(isDisplayed()))
        onView(withId(R.id.iv_detail)).check(matches(withTagValue(equalTo(dummyTvShow[0].poster))))
        onView(withId(R.id.collapsing)).check(matches(isDisplayed()))
        onView(withId(R.id.collapsing)).check(matches(withContentDescription(dummyTvShow[0].title)))
        onView(withId(R.id.tv_detail_genre_duration)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_genre_duration)).check(matches(withText("${dummyTvShow[0].genre} | ${dummyTvShow[0].duration}")))
        onView(withId(R.id.tv_detail_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_overview)).check(matches(withText(dummyTvShow[0].overview)))
    }
}