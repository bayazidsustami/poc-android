package com.example.home.discover.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.commons.components.viewmodel.ViewModelFactory
import com.example.commons.components.viewmodel.ViewModelKey
import com.example.home.discover.presentation.viewmodel.HomeDiscoverViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeDiscoverViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeDiscoverViewModel::class)
    abstract fun bindHomeDiscoverViewModel(viewModel: HomeDiscoverViewModel): ViewModel


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}