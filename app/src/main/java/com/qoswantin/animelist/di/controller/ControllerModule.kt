package com.qoswantin.animelist.di.controller

import android.content.Context
import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.di.application.ApplicationModule.Companion.APPLICATION_CONTEXT
import com.qoswantin.animelist.ui.FragmentNavigator
import com.qoswantin.animelist.ui.animeList.AnimeListContract
import com.qoswantin.animelist.ui.animeList.AnimeListPresenter
import com.qoswantin.animelist.ui.animeList.AnimeAdapter
import com.qoswantin.animelist.ui.animeReview.AnimeReviewContract
import com.qoswantin.animelist.ui.animeReview.AnimeReviewPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ControllerModule {

    @Provides
    fun provideAnimeListPresenter(
        animeRepository: AnimeRepository,
        fragmentNavigator: FragmentNavigator,
        animeAdapter: AnimeAdapter
    ): AnimeListContract.Presenter {
        return AnimeListPresenter(
            animeRepository,
            fragmentNavigator,
            animeAdapter
        )
    }

    @Provides
    fun provideAnimeReviewPresenter(
        animeRepository: AnimeRepository
    ): AnimeReviewContract.Presenter {
        return AnimeReviewPresenter(animeRepository)
    }

    @ControllerScope
    @Provides
    fun provideAnimeAdapter(
        @Named(APPLICATION_CONTEXT) context: Context
    ): AnimeAdapter {
        return AnimeAdapter(
            context
        )
    }

}