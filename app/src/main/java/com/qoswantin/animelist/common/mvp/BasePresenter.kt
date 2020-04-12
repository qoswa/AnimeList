package com.qoswantin.animelist.common.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {

    private var view: T? = null

    val compositeDisposable = CompositeDisposable()

    override fun attachView(mvpView: T) {
        view = mvpView
    }

    override fun detachView() {
        view = null
        compositeDisposable.dispose()
    }

}