package com.qoswantin.animelist.common

import android.app.Application
import com.qoswantin.animelist.common.di.CompositionRoot

class AnimeListApp : Application() {

    private lateinit var compositionRoot: CompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = CompositionRoot()
    }

    fun getCompositionRoot(): CompositionRoot {
        return compositionRoot
    }

}