package com.qoswantin.animelist.ui.animeReview

import com.qoswantin.animelist.common.mvp.BasePresenter
import com.qoswantin.animelist.dataSource.AnimeRepository

class AnimeReviewPresenter (
    val animeRepository: AnimeRepository
): BasePresenter<AnimeReviewContract.View>(), AnimeReviewContract.Presenter {


    override fun attachView(mvpView: AnimeReviewContract.View) {
        super.attachView(mvpView)
        animeRepository
            .getAnimeByReviewsByAnimeId()
    }
}