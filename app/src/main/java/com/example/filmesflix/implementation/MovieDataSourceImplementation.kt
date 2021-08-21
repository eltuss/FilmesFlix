package com.example.filmesflix.implementation

import android.util.Log
import com.example.filmesflix.Domain.Movie
import com.example.filmesflix.framework.api.MovieRestApiTask
import com.example.filmesflix.data.MovieDataSource

class MovieDataSourceImplementation(private val movieRestApiTask: MovieRestApiTask): MovieDataSource  {

    companion object{
        const val TAG = "MovieRepository"
    }

    private val movieList = arrayListOf<Movie>()


    override fun getAllMovies(): List<Movie> {
        val request = movieRestApiTask.retrofitApi().getAllMovies().execute()

        if (request.isSuccessful){
            request.body()?.let {
                movieList.addAll(it)
            }
        }else{
            request.errorBody()?.let {
                Log.d(TAG, it.toString())
            }

        }

        return movieList
    }
}