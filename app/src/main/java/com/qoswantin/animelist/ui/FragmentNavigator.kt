package com.qoswantin.animelist.ui

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import com.qoswantin.animelist.ui.animeList.AnimeListFragment

class FragmentNavigator (
    private val activity: FragmentActivity,
    private val fragmentManager: FragmentManager
) {

    // According to documentation
    // https://developer.android.com/reference/android/content/res/Resources.html#getIdentifier
    // resource can not has id = 0, so we can use it as default "null" value.
    @IdRes
    private var containerIdRes: Int = 0

    fun initWithAnimeListFragment(
        @IdRes container: Int
    ) {
        containerIdRes = container
        pushFragment(AnimeListFragment.newInstance())
    }

    fun onBackPressed() {
        if (fragmentManager.backStackEntryCount > 0)
            fragmentManager.popBackStack()
        else
            activity.finish()
    }

    fun openAnimeDetailsFragment() {
//        pushFragment(AnimeDetailsFragment.newInstance())
    }

    private fun pushFragment(fragment: Fragment) {
        checkForContainer()
        fragmentManager
            .beginTransaction()
            .replace(containerIdRes, fragment)
            .addToBackStack(null)
            .commit()
    }

    private fun checkForContainer() {
        check(containerIdRes != 0) {
            "You must initFragmentNavigator with containerId first."
        }
    }

}