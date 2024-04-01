package com.example.home.discover.presentation.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.core.applications.coreComponent
import com.example.home.discover.R
import com.example.home.discover.di.DaggerHomeDiscoverComponent
import com.example.home.discover.presentation.viewmodel.HomeDiscoverViewModel
import javax.inject.Inject

class HomeDiscoverActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val viewModel by viewModels<HomeDiscoverViewModel> { factory }

    companion object {
        fun launch(context: Context) {
            context.startActivity(Intent(context, HomeDiscoverActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
        enableEdgeToEdge()
        setContentView(R.layout.activity_home_discover)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel.loadContent()

        findViewById<AppCompatTextView>(R.id.tv_click).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("example://movies/movie-favorite")))
        }
    }

    private fun inject() {
        DaggerHomeDiscoverComponent.factory()
            .create(coreComponent())
            .inject(this)
    }
}