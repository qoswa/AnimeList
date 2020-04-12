package com.qoswantin.animelist.ui.animeList

import com.qoswantin.animelist.common.mvp.BasePresenter
import com.qoswantin.animelist.common.utils.addTo
import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.ui.FragmentNavigator
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeListPresenter(
    private val animeRepository: AnimeRepository,
    private val fragmentNavigator: FragmentNavigator
) : BasePresenter<AnimeListContract.View>(), AnimeListContract.Presenter {

    override fun attachView(mvpView: AnimeListContract.View) {
        super.attachView(mvpView)
        animeRepository.getAnimeList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { animeList ->
                    view?.showAnimeList(animeList)
                },
                { throwable ->
                    throwable.printStackTrace()
                }
            )
            .addTo(compositeDisposable)
    }


    override fun onAnimeClicked(animeId: Int) {
        fragmentNavigator.openAnimeDetailsFragment(animeId)
    }

}