package com.riyaldi.moviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.riyaldi.moviecatalogue.data.MovieEntity

class DetailViewModel: ViewModel() {
    private lateinit var film: MovieEntity

//    fun setFilm(id: String, category: String) {
//        when (category) {
//            "tvShow" -> {
//                for (tvShow in DataDummy.getTvShows()) {
//                    if (tvShow.id == id) film = tvShow
//                }
//            }
//
//            "movie" -> {
//                for (movie in DataDummy.getMovies()) {
//                    if (movie.id == id) film = movie
//                }
//            }
//        }
//    }

    fun getFilmDetail() = film

}