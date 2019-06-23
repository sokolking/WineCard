package com.pax.winecard.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.pax.winecard.R
import com.pax.winecard.domain.entities.Item
import com.pax.winecard.view.adapter.ItemAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val items = arrayListOf<Item>()
    private val adapter: ItemAdapter = ItemAdapter(arrayListOf()) { i -> selected(i) }

    private fun selected(i: Item) {
        init()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        recycler_view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycler_view.adapter = adapter
    }

    private fun init() {
        for (i in 1..100) {
            items.add(Item(i, i.toString()))
        }
        adapter.setItems(items)
        recycler_view.scheduleLayoutAnimation()
    }
}
