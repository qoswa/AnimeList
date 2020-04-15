package com.qoswantin.animelist.di.controller

import com.qoswantin.animelist.ui.AnimeActivity
import com.qoswantin.animelist.ui.animeList.AnimeListFragment
import com.qoswantin.animelist.ui.animeReview.AnimeReviewFragment
import dagger.Subcomponent

@ControllerScope
@Subcomponent(modules = [ControllerModule::class])
interface ControllerComponent {

    fun inject(animeActivity: AnimeActivity)

    fun inject(animeListFragment: AnimeListFragment)

    fun inject(animeReviewFragment: AnimeReviewFragment)

}