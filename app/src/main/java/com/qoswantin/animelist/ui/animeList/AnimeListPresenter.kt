package com.qoswantin.animelist.ui.animeList

import androidx.recyclerview.widget.RecyclerView
import com.qoswantin.animelist.common.mvp.BasePresenter
import com.qoswantin.animelist.common.utils.addTo
import com.qoswantin.animelist.dataSource.AnimeRepository
import com.qoswantin.animelist.ui.FragmentNavigator
import com.qoswantin.animelist.ui.animeList.adapter.AnimeAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class AnimeListPresenter(
    private val animeRepository: AnimeRepository,
    private val fragmentNavigator: FragmentNavigator,
    private val animeAdapter: AnimeAdapter
) : BasePresenter<AnimeListContract.View>(), AnimeListContract.Presenter {

    override fun attachView(mvpView: AnimeListContract.View) {
        super.attachView(mvpView)
        animeRepository.getAnimeList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { animeList ->
                    animeAdapter.addAnimeList(animeList)
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