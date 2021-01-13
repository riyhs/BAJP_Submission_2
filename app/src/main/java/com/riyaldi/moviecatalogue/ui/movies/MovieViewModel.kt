package com.riyaldi.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import com.riyaldi.moviecatalogue.utils.DataDummy

class MovieViewModel: ViewModel() {
    fun getMovies() = DataDummy.getMovies()
}