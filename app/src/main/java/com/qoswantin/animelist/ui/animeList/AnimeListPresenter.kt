package com.qoswantin.animelist.ui.animeList

import com.qoswantin.animelist.common.mvp.BasePresenter

class AnimeListPresenter : BasePresenter<AnimeListContract.View>(), AnimeListContract.Presenter {

    override fun attachView(mvpView: AnimeListContract.View) {
        super.attachView(mvpView)
    }

    override fun onAnimeClicked(animeId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}