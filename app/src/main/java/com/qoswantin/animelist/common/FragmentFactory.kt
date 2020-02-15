package com.qoswantin.animelist.common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.qoswantin.animelist.animeList.AnimeListFragment
import com.qoswantin.animelist.common.di.CompositionRoot

class FragmentFactory (
    val compositionRoot: CompositionRoot
): FragmentFactory() {


    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        if (className == AnimeListFragment::class.java.name){
            return AnimeListFragment()
        }

        return super.instantiate(classLoader, className)
    }


}