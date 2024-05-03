package com.example.home.discover.presentation.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.commons.components.activity.BaseActivity
import com.example.home.discover.R
import com.example.home.discover.di.DaggerHomeDiscoverComponent
import com.example.home.discover.presentation.viewmodel.HomeDiscoverViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeDiscoverActivity : BaseActivity() {

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

        populateData()
    }

    override fun injectComponent() {
        DaggerHomeDiscoverComponent.factory()
            .create(getActivityComponent())
            .inject(this)
    }

    private fun populateData() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.homeContent.collectLatest {
                    Log.d("DATA", it.toString())
                }
            }
        }
    }
}