package com.qoswantin.animelist.di.application

import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.dataSource.JikanApi
import dagger.Module
import dagger.Provides

@Module
class AnimeModule {

    @ApplicationScope
    @Provides
    fun provideAnimeRepository(jikanApi: JikanApi): AnimeRepository {
        return AnimeRepository(jikanApi)
    }

}