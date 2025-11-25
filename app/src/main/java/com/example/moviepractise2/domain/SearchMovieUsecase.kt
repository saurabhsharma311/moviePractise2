package com.example.moviepractise2.domain

import com.example.moviepractise2.data.remote.model.Movie
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchMovieUsecase @Inject constructor (val repo : MovieRepo ){

    operator fun invoke(query3: String) : Flow<List<Movie>>{
        return repo.searchMovies(query3)
    }
}