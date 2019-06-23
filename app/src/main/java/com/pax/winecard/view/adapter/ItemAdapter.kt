package com.pax.winecard.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pax.winecard.R
import com.pax.winecard.domain.entities.Item
import kotlinx.android.synthetic.main.item_item.view.*

class ItemAdapter(private var items: List<Item>, private val listener: (Item) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        items[position].let { holder.bind(it, listener) }
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_item

    override fun getItemCount(): Int = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Item, listener: (Item) -> Unit) = with(itemView) {
            button.text = item.name
            button.setOnClickListener { listener(item) }
        }
    }

    fun setItems(tables: List<Item>) {
        this.items = tables
        notifyDataSetChanged()
    }

}
