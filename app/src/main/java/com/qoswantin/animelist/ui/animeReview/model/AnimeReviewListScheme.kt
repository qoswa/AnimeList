package com.qoswantin.animelist.ui.animeReview.model

import com.google.gson.annotations.SerializedName

data class AnimeReviewListScheme (
    @SerializedName("reviews") val reviews : List<ReviewScheme>
)