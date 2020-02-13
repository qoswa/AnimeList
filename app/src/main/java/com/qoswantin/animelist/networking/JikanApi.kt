package com.qoswantin.animelist.networking

import com.qoswantin.animelist.animeList.model.AnimeScheme
import com.qoswantin.animelist.animeList.model.TopAnimeListScheme
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApi {

    @GET("top/anime/")
    fun getTopAnimeList(): Single<TopAnimeListScheme>

    @GET("anime/{id}")
    fun getAnime(@Path("id") id: Int): Single<AnimeScheme>

}
