package com.example.commons.components.activity.di

import com.example.commons.components.activity.BaseActivity
import com.example.core.applications.AppComponent
import dagger.Component

@ActivityScope
@Component(
    dependencies = [
        AppComponent::class
    ]
)
interface BaseActivityComponent {

    fun inject(activity: BaseActivity)

}