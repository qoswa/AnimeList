package com.qoswantin.animelist.ui.animeList.model

import com.google.gson.annotations.SerializedName

data class TopAnimeListScheme(
    @SerializedName("top") val animeList: List<AnimeScheme>
)