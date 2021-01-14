package com.riyaldi.moviecatalogue.network

import com.riyaldi.moviecatalogue.data.source.remote.response.movie.MoviesResponse
import com.riyaldi.moviecatalogue.data.source.remote.response.tv.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String
    ) : Call<MoviesResponse>

    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") apiKey: String
    ) : Call<TvShowResponse>
}