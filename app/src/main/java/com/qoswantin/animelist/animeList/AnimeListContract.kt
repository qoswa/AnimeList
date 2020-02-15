package com.qoswantin.animelist.animeList

import com.qoswantin.animelist.animeList.model.Anime
import com.qoswantin.animelist.common.utils.mvp.MvpPresenter
import com.qoswantin.animelist.common.utils.mvp.MvpView

interface AnimeListContract {


    interface View: MvpView {

        fun showAnimeList(animeList: List<Anime>)

    }

    interface Presenter: MvpPresenter<View>{

        fun onAnimeClicked(animeId: Int)

    }

}