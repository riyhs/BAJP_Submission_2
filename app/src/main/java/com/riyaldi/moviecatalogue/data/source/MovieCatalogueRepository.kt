package com.riyaldi.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.riyaldi.moviecatalogue.data.MovieEntity
import com.riyaldi.moviecatalogue.data.TvShowEntity
import com.riyaldi.moviecatalogue.data.source.remote.RemoteDataSource
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.Movie
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.MovieDetailResponse
import com.riyaldi.moviecatalogue.data.source.remote.response.tv.TvShow

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource{
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getMovies(): LiveData<List<MovieEntity>> {
        val movieResult = MutableLiveData<List<MovieEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: List<Movie>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val movie = MovieEntity(id, title, posterPath, voteAverage)
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }
        })
        return movieResult
    }

    override fun getDetailMovie(movieId: String): LiveData<MovieDetailResponse> {
        val movieDetailResult = MutableLiveData<MovieDetailResponse>()

        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null) {
                    movieDetailResult.postValue(movieDetail)
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getTvShows(): LiveData<List<TvShowEntity>> {
        val tvResult = MutableLiveData<List<TvShowEntity>>()

        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: List<TvShow>?) {
                val tvList = ArrayList<TvShowEntity>()
                if (tvShows != null) {
                    for (response in tvShows) {
                        with(response) {
                            val tvShow = TvShowEntity(id, name, posterPath, voteAverage)
                            tvList.add(tvShow)
                        }
                    }
                    tvResult.postValue(tvList)
                }
            }
        })
        return tvResult
    }
}