package com.qoswantin.animelist.ui.animeReview

import com.qoswantin.animelist.common.mvp.MvpPresenter
import com.qoswantin.animelist.common.mvp.MvpView

interface AnimeReviewContract {

    interface View: MvpView {

    }

    interface Presenter: MvpPresenter<View> {

    }

}
