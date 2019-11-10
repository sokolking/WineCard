package com.pax.winecard.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pax.winecard.R
import com.pax.winecard.app.App
import com.pax.winecard.domain.models.BaseModel
import com.pax.winecard.domain.models.Category
import com.pax.winecard.domain.models.FilterItem
import com.pax.winecard.view.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity(), IMainPresenter.View {

    private val adapter: ItemAdapter = ItemAdapter(arrayListOf()) { i -> selected(i) }
    @Inject
    lateinit var presenter: IMainPresenter.Presenter
    private var step = 0
    private var stack = ArrayDeque<String>()
    private var items = arrayListOf<BaseModel>()
    private var filters = HashMap<String, String>()
    private var itemId = -1
    private var code = ""

    private fun selected(i: BaseModel) {
        if (step == 0) {
            presenter.getFilterItem(i.id!!, filters)
            itemId = i.id!!
        } else {
            stack.push(code)
            filters.put("filters[${stack.first}]", i.id!!.toString())
            presenter.getFilterItem(i.id!!, filters)
        }
        step++
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.logis.inject(this)
        presenter.attachView(this)
        presenter.getCategories()
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    override fun onGetCategoriesSuccess(categories: List<Category>) {
        adapter.setItems(categories)
        recycler_view.scheduleLayoutAnimation()
    }

    override fun onBackPressed() {
        if (stack.isEmpty() && step == 0) {
            super.onBackPressed()
        } else {
            if (stack.isEmpty()) {
                presenter.getCategories()
                step--
            } else {
                filters.remove("filters[${stack.pop()}]")
                presenter.getFilterItem(itemId, filters)
                step--
            }
        }
    }

    override fun onFilterItemSuccess(filterItems: FilterItem) {
        adapter.setItems(filterItems.filterData!!)
        items.addAll(filterItems.filterData)
        code = filterItems.code!!
        recycler_view.scheduleLayoutAnimation()
    }

    override fun onFailed(message: String) {

    }
}
