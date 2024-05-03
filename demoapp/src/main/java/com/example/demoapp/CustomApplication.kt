package com.example.demoapp

import android.util.Log
import com.example.core.applications.MovieApplication

class CustomApplication: MovieApplication() {

    override fun onCreate() {
        super.onCreate()
        Log.d(CustomApplication::class.java.name, "created")
    }

}