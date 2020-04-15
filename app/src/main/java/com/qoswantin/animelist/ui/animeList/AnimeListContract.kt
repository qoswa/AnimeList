package com.qoswantin.animelist.ui.animeList

import android.os.Parcelable
import com.qoswantin.animelist.ui.animeList.model.Anime
import com.qoswantin.animelist.common.mvp.MvpPresenter
import com.qoswantin.animelist.common.mvp.MvpView

interface AnimeListContract {


    interface View: MvpView {

        fun restoreListState(savedListPosition: Int?)

        fun showProgress()

        fun hideProgress()

        fun showEmptyStub()

        fun showError()

    }

    interface Presenter : MvpPresenter<View> {

        fun onCreateView(savedListPosition: Int?)

        fun onAnimeClicked(animeId: Int)

    }

}