package com.example.moviepractise2.data.remote.model

data class SearchResponse(
    val search: List<Movie>,
    val totalResults: String,
    val response: String
)