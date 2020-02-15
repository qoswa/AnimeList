package com.qoswantin.animelist.common

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import com.qoswantin.animelist.common.di.CompositionRoot

@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    var compositionRoot: CompositionRoot? = null

    fun compositionRoot() = compositionRoot ?: (application as AnimeListApp)
        .getCompositionRoot().also {
            compositionRoot = it
        }

}
