package com.example.home.discover.domain.model

data class HomeModelDomain<out G, M>(
    val genres: G,
    val movies: M,
)