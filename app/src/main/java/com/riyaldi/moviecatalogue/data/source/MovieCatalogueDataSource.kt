package com.riyaldi.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.riyaldi.moviecatalogue.data.DetailEntity
import com.riyaldi.moviecatalogue.data.MovieEntity
import com.riyaldi.moviecatalogue.data.TvShowEntity
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<List<TvShowEntity>>
    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}