package com.example.laboratorio05cabanas

import android.app.Application
import com.example.laboratorio05cabanas.data.movies
import com.example.laboratorio05cabanas.repository.MovieRepository

class MovieReviewerApplication: Application() {
    val movieRepository: MovieRepository by lazy {
        MovieRepository(movies)
    }
}