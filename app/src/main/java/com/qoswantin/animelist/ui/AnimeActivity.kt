package com.qoswantin.animelist.ui

import android.os.Bundle
import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseActivity
import okhttp3.OkHttpClient
import javax.inject.Inject

class AnimeActivity : BaseActivity() {

    @Inject
    lateinit var okHttpClient: OkHttpClient

    override fun onCreate(savedInstanceState: Bundle?) {
        controllerComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
