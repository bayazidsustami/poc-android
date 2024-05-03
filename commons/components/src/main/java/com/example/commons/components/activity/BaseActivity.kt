package com.example.commons.components.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.commons.components.activity.di.BaseActivityComponent
import com.example.commons.components.activity.di.DaggerBaseActivityComponent
import com.example.core.applications.coreComponent

abstract class BaseActivity: AppCompatActivity() {

    private lateinit var activityComponent: BaseActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initInjection()
        injectComponent()
    }

    abstract fun injectComponent()

    private fun initInjection() {
        activityComponent = DaggerBaseActivityComponent.builder()
            .appComponent(coreComponent())
            .build()
    }

    protected fun getActivityComponent(): BaseActivityComponent {
        if (!::activityComponent.isInitialized) {
            initInjection()
        }

        return activityComponent
    }
}