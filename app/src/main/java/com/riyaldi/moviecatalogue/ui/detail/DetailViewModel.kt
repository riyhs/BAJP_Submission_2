package com.riyaldi.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riyaldi.moviecatalogue.data.MovieEntity
import com.riyaldi.moviecatalogue.data.source.MovieCatalogueRepository
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse

class DetailViewModel(private val movieCatalogueRepository: MovieCatalogueRepository): ViewModel() {
    companion object {
        const val MOVIE = "movie"
    }

    private lateinit var movie: LiveData<MovieDetailResponse>
    private lateinit var film: MovieEntity

    fun setFilm(id: String, category: String) {
        when (category) {
//            "tvShow" -> {
//                for (tvShow in DataDummy.getTvShows()) {
//                    if (tvShow.id == id) film = tvShow
//                }
//            }

            MOVIE -> {
                movie = movieCatalogueRepository.getDetailMovie(id)
            }
        }
    }

    fun getMovieDetail() = movie

}