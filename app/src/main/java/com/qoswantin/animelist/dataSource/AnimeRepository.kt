package com.qoswantin.animelist.dataSource

import com.qoswantin.animelist.networking.JikanApi
import com.qoswantin.animelist.ui.animeList.model.Anime
import com.qoswantin.animelist.ui.animeList.model.AnimeScheme
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
            .flatMapObservable { Observable.fromIterable(it) }
            .map { animeScheme ->
                animeScheme.toModel()
            }.toList()
    }

    fun getAnimeById(id: Int): Single<Anime> {
        return jikanApi.getAnime(id)
            .map { it.toModel() }
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