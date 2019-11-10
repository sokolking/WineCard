package com.pax.winecard.data.presenter

interface IBasePresenter<in V: IBaseView> {
    fun detachView()
    fun attachView(view: V)
}
