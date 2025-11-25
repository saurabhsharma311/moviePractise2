package com.example.moviepractise2.domain

import com.example.moviepractise2.data.remote.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepo {
     fun  searchMovies(query3: String) : Flow<List<Movie>>
}