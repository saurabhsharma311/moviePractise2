package com.example.moviepractise2.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviepractise2.data.remote.model.Movie
import com.example.moviepractise2.domain.SearchMovieUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieViewModel @Inject constructor(val useCase: SearchMovieUsecase) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState<List<Movie>>>(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }

    fun searchMovies(query: String) {
        if (query.isNullOrEmpty()) {
            _uiState.value = UiState.Success(emptyList())
            return
        }

        viewModelScope.launch {
            useCase(query).onStart {
                _uiState.value = UiState.Loading
            }.catch { e ->
                _uiState.value = UiState.Error(e.message.toString())
            }.collect { movies ->
                _uiState.value = UiState.Success(movies)

            }
        }
    }

}