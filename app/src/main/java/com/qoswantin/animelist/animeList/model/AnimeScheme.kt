package com.qoswantin.animelist.animeList.model

import com.google.gson.annotations.SerializedName

data class AnimeScheme(
    @SerializedName("mal_id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("score") val score: Double,
    @SerializedName("image_url") val imageUrl: String
)