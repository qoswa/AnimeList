package com.qoswantin.animelist.ui.animeList

import com.qoswantin.animelist.ui.animeList.model.Anime
import com.qoswantin.animelist.common.mvp.MvpPresenter
import com.qoswantin.animelist.common.mvp.MvpView

interface AnimeListContract {


    interface View: MvpView {
        fun showAnimeList(animeList: List<Anime>)
    }

    interface Presenter: MvpPresenter<View> {
        fun onAnimeClicked(animeId: Int)
    }

}