package com.example.home.discover.presentation.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.commons.components.viewmodel.ViewModelFactory
import com.example.home.discover.R
import com.example.home.discover.presentation.viewmodel.HomeDiscoverViewModel
import javax.inject.Inject

class HomeDiscoverActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

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
    }
}