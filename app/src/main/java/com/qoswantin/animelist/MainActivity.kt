package com.qoswantin.animelist

import android.os.Bundle
import com.qoswantin.animelist.animeList.AnimeListFragment
import com.qoswantin.animelist.common.BaseActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.fragmentFactory =
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container_view,

            )
            .addToBackStack(null)
            .commit()
    }

}
