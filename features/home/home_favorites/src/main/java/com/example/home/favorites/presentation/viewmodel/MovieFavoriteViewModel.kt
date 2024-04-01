package com.example.home.favorites.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.coroutine.qualifiers.MainDispatcher
import com.example.home.favorites.domain.GetFavoriteMovieUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieFavoriteViewModel @Inject constructor(
    private val getFavoriteMovieUseCase: GetFavoriteMovieUseCase,
    @MainDispatcher
    private val dispatcher: CoroutineDispatcher,
) : ViewModel() {

    fun getFavMovie() {
        viewModelScope.launch(dispatcher){
            getFavoriteMovieUseCase.invoke().collect()
        }
    }
}