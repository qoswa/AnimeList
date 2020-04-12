package com.qoswantin.animelist.common.mvp

interface MvpPresenter<V : MvpView> {


    /**
     * Called when the view has already created
     *
     * @param mvpView reference to view component
     */
    fun attachView(mvpView: V)

    /**
     * Called when the view is going to be destroyed
     */
    fun detachView()

}
