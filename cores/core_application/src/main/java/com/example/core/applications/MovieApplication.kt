package com.example.core.applications

import android.app.Activity
import android.app.Application
import android.content.Context

open class MovieApplication: Application() {

    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }

    companion object {
        fun appComponent(context: Context) =
            (context.applicationContext as MovieApplication).appComponent
    }
}

fun Activity.coreComponent() = MovieApplication.appComponent(this)