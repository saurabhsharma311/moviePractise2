package com.example.moviepractise2.data.remote.model

data class SearchResponse(
    val Search: List<Movie>,
    val totalResults: String,
    val Response: String
)