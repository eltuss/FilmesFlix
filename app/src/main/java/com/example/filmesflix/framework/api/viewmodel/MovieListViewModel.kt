package com.example.filmesflix.framework.api.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmesflix.framework.api.MovieRestApiTask
import com.example.filmesflix.Domain.Movie
import com.example.filmesflix.data.MovieRepository
import com.example.filmesflix.implementation.MovieDataSourceImplementation
import com.example.filmesflix.usecase.MoviesListUseCase

class MovieListViewModel: ViewModel() {

    companion object{
        const val TAG = "MovieRepository"
    }
    private val movieRestApiTask = MovieRestApiTask()
    private val movieDataSource = MovieDataSourceImplementation(movieRestApiTask)
    private val movieRepository = MovieRepository(movieDataSource)
    private val moviesListUseCase = MoviesListUseCase(movieRepository)

    private var _moviesList = MutableLiveData<List<Movie>>()
    val moviesList: LiveData<List<Movie>>
    get() = _moviesList

    fun init(){
        getAllMovies()
    }

    private fun getAllMovies() {
        Thread{
            try {
                _moviesList.postValue(moviesListUseCase.invoke())
            }catch (exception: Exception){
                Log.d(TAG,exception.message.toString())
            }
        }.start()
    }

}