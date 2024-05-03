package com.example.home.favorites.presentation.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.commons.components.activity.BaseActivity
import com.example.core.applications.coreComponent
import com.example.home.favorites.R
import com.example.home.favorites.di.DaggerHomeFavoriteComponent
import com.example.home.favorites.presentation.viewmodel.MovieFavoriteViewModel
import javax.inject.Inject

class MovieFavoriteActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MovieFavoriteViewModel by viewModels<MovieFavoriteViewModel> { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_movie_favorite)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.getFavMovie()
    }

    override fun injectComponent() {
        DaggerHomeFavoriteComponent.factory()
            .create(getActivityComponent(), this)
            .inject(this)
    }
}