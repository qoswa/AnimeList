package com.qoswantin.animelist.ui.animeReview

import com.qoswantin.animelist.common.mvp.BasePresenter
import com.qoswantin.animelist.utils.addTo
import com.qoswantin.animelist.dataSource.AnimeRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeReviewPresenter (
    private val animeRepository: AnimeRepository
): BasePresenter<AnimeReviewContract.View>(), AnimeReviewContract.Presenter {


    override fun onCreateView(animeId: Int) {
        animeRepository
            .getReviewsByAnimeId(animeId)
            .map { it.first() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { view?.showProgress() }
            .doOnTerminate { view?.hideProgress() }
            .subscribe(
                {
                    view?.showAnimeReview(it.content)
                },
                {
                    view?.showError()
                }
            )
            .addTo(compositeDisposable)

    }
}