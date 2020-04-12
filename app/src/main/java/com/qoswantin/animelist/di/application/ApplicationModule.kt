package com.qoswantin.animelist.di.application

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ApplicationModule {

    @ApplicationScope
    @Provides
    @Named(APPLICATION_CONTEXT)
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    companion object {
        const val APPLICATION_CONTEXT = "APPLICATION_CONTEXT"
    }

}
