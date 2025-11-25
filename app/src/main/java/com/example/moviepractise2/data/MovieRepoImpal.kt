package com.example.moviepractise2.data

import android.util.Log
import com.example.moviepractise2.data.remote.model.Movie
import com.example.moviepractise2.data.remote.model.SearchMovieApi
import com.example.moviepractise2.domain.MovieRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepoImpal @Inject constructor(private val api: SearchMovieApi) : MovieRepo {
    override  fun searchMovies(query: String): Flow<List<Movie>> = flow {
        try {
            val response = api.searchMovies(query = query)
            val movies = response.Search ?: emptyList()
            Log.d("TAG", "searchMovies: $movies")
            emit(movies)
        } catch (e: Exception) {
            emit(emptyList())
        }
    }
}