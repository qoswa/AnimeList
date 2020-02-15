package com.qoswantin.animelist.animeList.model

import com.google.gson.annotations.SerializedName

data class Anime(
    val id: Int,
    val title: String,
    val score: Double,
    val imageUrl: String
)