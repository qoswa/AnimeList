package com.qoswantin.animelist.common

import androidx.fragment.app.Fragment
import com.qoswantin.animelist.common.di.FragmentPresentationRoot

open class BaseFragment: Fragment(){

    var presentationRoot: FragmentPresentationRoot? = null

    fun getCompositionRoot(): FragmentPresentationRoot {
        return presentationRoot ?: FragmentPresentationRoot(
            (activity!!.application as AnimeListApp).getCompositionRoot(),
            childFragmentManager)
                .also {
                    presentationRoot = it
                }
    }

}