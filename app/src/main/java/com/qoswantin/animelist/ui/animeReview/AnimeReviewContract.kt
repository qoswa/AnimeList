package com.qoswantin.animelist.ui.animeReview

import com.qoswantin.animelist.common.mvp.MvpPresenter
import com.qoswantin.animelist.common.mvp.MvpView

interface AnimeReviewContract {

    interface View: MvpView {

        fun showAnimeReview(anime: String)

        fun showProgress()

        fun hideProgress()

        fun showError()

    }

    interface Presenter: MvpPresenter<View> {

        fun onCreateView(animeId: Int)

    }

}
