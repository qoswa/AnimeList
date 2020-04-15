package com.qoswantin.animelist.dataSource

import com.qoswantin.animelist.networking.JikanApi
import com.qoswantin.animelist.ui.animeList.model.Anime
import com.qoswantin.animelist.ui.animeList.model.AnimeScheme
import com.qoswantin.animelist.ui.animeReview.model.Review
import com.qoswantin.animelist.ui.animeReview.model.ReviewScheme
import io.reactivex.Observable
import io.reactivex.Single

class AnimeRepository(
    private val jikanApi: JikanApi
) {

    fun getAnimeList(): Single<List<Anime>> {
        return jikanApi.getTopAnimeList()
            .map { topAnimeListScheme ->
                topAnimeListScheme.animeList
            }
            .map { animeSchemeList ->
                animeSchemeList.map { it.toModel() }
            }
    }

    fun getReviewsByAnimeId(id: Int): Single<List<Review>> {
        return jikanApi.getReviewsByAnimeId(id)
            .map { it.reviews }
            .map { list ->
                list.map { it.toModel() }
            }
    }

}

fun AnimeScheme.toModel(): Anime {
    return Anime(
        id,
        title,
        score,
        imageUrl
    )
}

fun ReviewScheme.toModel(): Review {
    return Review(
        content
    )
}