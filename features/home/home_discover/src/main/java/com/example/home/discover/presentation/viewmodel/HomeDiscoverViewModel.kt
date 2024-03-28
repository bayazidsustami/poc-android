package com.example.home.discover.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.home.discover.domain.GetHomeContentUseCase
import javax.inject.Inject

class HomeDiscoverViewModel @Inject constructor(
    private val useCase: GetHomeContentUseCase
) : ViewModel() {
}