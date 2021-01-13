package com.riyaldi.moviecatalogue.ui.movies

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovies() {
        val movie = viewModel.getMovies()
        assertNotNull(movie)
        assertEquals(10, movie.size)
    }
}