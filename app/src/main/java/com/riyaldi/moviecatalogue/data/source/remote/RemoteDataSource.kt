package com.riyaldi.moviecatalogue.data.source.remote

import android.util.Log
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.Movie
import com.riyaldi.moviecatalogue.data.source.remote.response.movie.MoviesResponse
import com.riyaldi.moviecatalogue.data.source.remote.response.tv.TvShow
import com.riyaldi.moviecatalogue.data.source.remote.response.tv.TvShowResponse
import com.riyaldi.moviecatalogue.network.ApiConfig
import com.riyaldi.moviecatalogue.utils.NetworkInfo.API_KEY
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(callback: LoadMoviesCallback) {
        val client = ApiConfig.getApiService().getMovies(API_KEY)
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                callback.onMoviesLoaded(response.body()?.results)
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
            }

        })
    }

    fun getTvShows(callback: LoadTvShowsCallback) {
        val client = ApiConfig.getApiService().getTvShows(API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                callback.onTvShowsLoaded(response.body()?.results)
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
            }

        })
    }

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies : List<Movie>?)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsLoaded(tvShows : List<TvShow>?)
    }
}