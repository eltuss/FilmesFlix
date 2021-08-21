package com.example.filmesflix.data

import com.example.filmesflix.Domain.Movie

interface MovieDataSource {

    fun getAllMovies(): List<Movie>
}