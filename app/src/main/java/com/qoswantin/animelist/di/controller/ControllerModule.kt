package com.qoswantin.animelist.di.controller

import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.ui.animeList.AnimeListContract
import com.qoswantin.animelist.ui.animeList.AnimeListPresenter
import dagger.Module
import dagger.Provides

@Module
class ControllerModule {

    @Provides
    fun provideAnimeListPresenter(animeRepository: AnimeRepository): AnimeListContract.Presenter {
        return AnimeListPresenter(animeRepository)
    }

}