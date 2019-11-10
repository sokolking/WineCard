package com.pax.winecard.view.activity

import com.pax.winecard.app.App
import com.pax.winecard.data.presenter.BasePresenterImpl
import com.pax.winecard.data.repository.impl.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter : BasePresenterImpl<IMainPresenter.View>(), IMainPresenter.Presenter {

    @Inject
    lateinit var repository: Repository

    init {
        App.logis.inject(this)
    }

    override fun getCategories() {
        repository.getCategories()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {
                    mView?.onFailed(it.message!!)
                }, onNext = {
                    mView?.onGetCategoriesSuccess(it)
                })
    }

    override fun getFilterItem(categoryId: Int, filters: HashMap<String, String>) {
        repository.getFilterItem(categoryId, filters)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onError = {
                    mView?.onFailed(it.localizedMessage)
                },
                onNext = {
                    mView?.onFilterItemSuccess(it.data!!)
                }
            )
    }

}
