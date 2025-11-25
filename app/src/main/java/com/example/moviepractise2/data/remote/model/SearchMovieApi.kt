package com.example.moviepractise2.data.remote.model

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchMovieApi {

    @GET("?")
    suspend fun searchMovies(
        @Query("apikey") api: String = "3e974fca",
        @Query("s") query: String
    ): SearchResponse
}