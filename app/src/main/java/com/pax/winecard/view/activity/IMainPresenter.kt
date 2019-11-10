package com.pax.winecard.view.activity

import com.pax.winecard.data.presenter.IBasePresenter
import com.pax.winecard.data.presenter.IBaseView
import com.pax.winecard.domain.models.Category
import com.pax.winecard.domain.models.FilterItem

object IMainPresenter {

    interface View : IBaseView {
        fun onGetCategoriesSuccess(categories: List<Category>)
        fun onFilterItemSuccess(filterItems: FilterItem)
        fun onFailed(message: String)
    }

    interface Presenter : IBasePresenter<View> {
        fun getCategories()
        fun getFilterItem(categoryId: Int, filters: HashMap<String, String>)
    }
}
