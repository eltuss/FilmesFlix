package com.example.filmesflix.usecase

import com.example.filmesflix.data.MovieRepository


class MoviesListUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke() = movieRepository.getAllMoviesFromDataSource()

}