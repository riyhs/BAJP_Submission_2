package com.riyaldi.moviecatalogue.utils

import com.riyaldi.moviecatalogue.data.source.local.entity.DetailEntity
import com.riyaldi.moviecatalogue.data.source.local.entity.MovieEntity
import com.riyaldi.moviecatalogue.data.source.local.entity.TvShowEntity

object DataDummy {
    fun getMovies(): List<MovieEntity> {
        return listOf(
            MovieEntity(
                464052,
                "Wonder Woman 1984",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                7.2
            ),
            MovieEntity(
                508442,
                "Soul",
                "/hm58Jw4Lw8OIeECIq5qyPYhAeRJ.jpg",
                8.4
            ),
            MovieEntity(
                517096,
                "Cosmoball",
                "/eDJYDXRoWoUzxjd52gtz5ODTSU1.jpg",
                5.3
            )
        )
    }

    fun getDetailMovie(): DetailEntity {
        return DetailEntity(
                "/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
                listOf("Fantasy", "Action", "Adventure"),
                468552,
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
                "/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
                "2020-12-16",
                151,
                "Wonder Woman 1984",
                7.2
        )
    }

    fun getTvShows(): List<TvShowEntity> {
        return listOf(
            TvShowEntity(
                77169,
                "Cobra Kai",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                8.1
            ),
            TvShowEntity(
                44217,
                "Vikings",
                "/bQLrHIRNEkE3PdIWQrZHynQZazu.jpg",
                8.0
            ),
            TvShowEntity(
                82856,
                "The Mandalorian",
                "/sWgBv7LV2PRoQgkxwlibdGXKz1S.jpg",
                8.5
            )
        )
    }

    fun getDetailTvShow(): DetailEntity {
        return DetailEntity(
                "/gL8myjGc2qrmqVosyGm5CWTir9A.jpg",
                listOf("Drama", "Action", "Adventure"),
                77169,
                "This Karate Kid sequel series picks up 30 years after the events of the 1984 All Valley Karate Tournament and finds Johnny Lawrence on the hunt for redemption by reopening the infamous Cobra Kai karate dojo. This reignites his old rivalry with the successful Daniel LaRusso, who has been working to maintain the balance in his life without mentor Mr. Miyagi.",
                "/obLBdhLxheKg8Li1qO11r2SwmYO.jpg",
                "2018-05-02",
                30,
                "Cobra Kai",
                8.1
        )
    }
}