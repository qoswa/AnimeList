package com.qoswantin.animelist.ui

import android.os.Bundle
import android.util.Log
import com.qoswantin.animelist.R
import com.qoswantin.animelist.common.baseComponents.BaseActivity
import okhttp3.OkHttpClient
import javax.inject.Inject

class AnimeActivity : BaseActivity() {

    @Inject
    lateinit var fragmentNavigator: FragmentNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        controllerComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentNavigator.setContainer(R.id.fragment_container_view)
        if (savedInstanceState == null) {
            fragmentNavigator.openAnimeListFragment()
        }

    }

    override fun onBackPressed() {
        fragmentNavigator.onBackPressed()
    }

}
