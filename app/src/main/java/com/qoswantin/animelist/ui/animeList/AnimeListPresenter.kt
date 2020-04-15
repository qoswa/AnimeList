package com.qoswantin.animelist.ui.animeList

import com.qoswantin.animelist.common.mvp.BasePresenter
import com.qoswantin.animelist.utils.addTo
import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.ui.FragmentNavigator
import com.qoswantin.animelist.ui.animeList.model.Anime
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class AnimeListPresenter(
    private val animeRepository: AnimeRepository,
    private val fragmentNavigator: FragmentNavigator,
    private val animeAdapter: AnimeAdapter
) : BasePresenter<AnimeListContract.View>(), AnimeListContract.Presenter,
    OnAnimeItemClicked {

    override fun attachView(mvpView: AnimeListContract.View) {
        super.attachView(mvpView)
        animeAdapter.setAnimeItemClickListener(this)
    }

    override fun onCreateView(savedListPosition: Int?) {
        // Decide if we really want to download data .
        // We don`t want to start rxChain with isEmpty() because
        // it will trigger doOnSubscribe() which will show progress bar
        if (animeAdapter.isEmpty()) {
            animeRepository.getAnimeList()
                .delay(1, TimeUnit.SECONDS) // Debugging purpose delay.
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { view?.showProgress() }
                .doOnTerminate { view?.hideProgress() }
                .subscribe(
                    { animeList ->
                        if (animeList.isNotEmpty()) {
                            animeAdapter.addAnimeList(animeList)
                            view?.restoreListState(savedListPosition)
                        } else {
                            view?.showEmptyStub()
                        }

                    },
                    { throwable ->
                        throwable.printStackTrace()
                        view?.showError()
                    }
                )
                .addTo(compositeDisposable)
        }
    }

    override fun onAnimeClicked(animeId: Int) {
        fragmentNavigator.openAnimeDetailsFragment(animeId)
    }

    override fun onAnimeItemClicked(item: Anime) {
        fragmentNavigator.openAnimeDetailsFragment(item.id)
    }

    override fun detachView() {
        super.detachView()
        animeAdapter.detachAnimeClickListener()
    }

}