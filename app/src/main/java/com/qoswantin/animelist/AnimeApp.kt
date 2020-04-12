package com.qoswantin.animelist

import android.app.Application
import com.qoswantin.animelist.di.application.ApplicationComponent
import com.qoswantin.animelist.di.application.DaggerApplicationComponent

class AnimeApp : Application() {

    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent {
        return appComponent
    }

}