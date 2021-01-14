package com.riyaldi.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.riyaldi.moviecatalogue.data.MovieEntity
import com.riyaldi.moviecatalogue.data.TvShowEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getTvShows(): LiveData<List<TvShowEntity>>
}