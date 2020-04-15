package com.qoswantin.animelist.common.mvp

import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter<T : MvpView> : MvpPresenter<T> {

    var view: T? = null

    val compositeDisposable = CompositeDisposable()

    override fun attachView(mvpView: T) {
        view = mvpView
    }

    override fun detachView() {
        view = null
        compositeDisposable.clear()
    }



}