package com.example.home.discover.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.discover.domain.GetHomeContentUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeDiscoverViewModel @Inject constructor(
    private val useCase: GetHomeContentUseCase
) : ViewModel() {

    private val _homeContent = MutableStateFlow<HomeDiscoverUIEvent>(HomeDiscoverUIEvent.Loading)
    val homeContent:StateFlow<HomeDiscoverUIEvent> get() = _homeContent

    fun loadContent() {
        viewModelScope.launch {
            useCase.invoke().onStart {
                _homeContent.value = HomeDiscoverUIEvent.Loading
            }.catch {
                _homeContent.value = HomeDiscoverUIEvent.Failed(it.message.orEmpty())
            }.collectLatest {
                _homeContent.value = HomeDiscoverUIEvent.Success(it)
            }
        }
    }
}