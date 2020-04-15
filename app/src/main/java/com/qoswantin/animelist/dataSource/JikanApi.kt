package com.qoswantin.animelist.dataSource

import com.qoswantin.animelist.ui.animeList.model.Anime
import com.qoswantin.animelist.ui.animeList.model.AnimeScheme
import com.qoswantin.animelist.ui.animeList.model.TopAnimeListScheme
import com.qoswantin.animelist.ui.animeReview.model.AnimeReviewListScheme
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface JikanApi {

    @GET("top/anime/")
    fun getTopAnimeList(): Single<TopAnimeListScheme>

    @GET("anime/{id}/reviews")
    fun getReviewsByAnimeId(@Path("id") id: Int): Single<AnimeReviewListScheme>

}
