package com.example.home.discover.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.home.discover.domain.GetHomeContentUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeDiscoverViewModel @Inject constructor(
    private val useCase: GetHomeContentUseCase
) : ViewModel() {

    fun loadContent() {
        viewModelScope.launch {
            useCase.invoke().collect()
        }
    }
}