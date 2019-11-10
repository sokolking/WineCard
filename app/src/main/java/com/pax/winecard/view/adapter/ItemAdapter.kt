package com.pax.winecard.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pax.winecard.R
import com.pax.winecard.domain.models.BaseModel
import com.pax.winecard.domain.models.Wine
import kotlinx.android.synthetic.main.item_item.view.*

class ItemAdapter(private var baseModels: List<BaseModel>, private val listener: (BaseModel) -> Unit) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        baseModels[position].let { holder.bind(it, listener) }
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_item

    override fun getItemCount(): Int = baseModels.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(baseModel: BaseModel, listener: (BaseModel) -> Unit) = with(itemView) {
            button.text = baseModel.name
            if (baseModel is Wine) {
                button.text = "${baseModel.name}  ${baseModel.description}"
            }
            button.setOnClickListener { listener(baseModel) }
        }
    }

    fun setItems(tables: List<BaseModel>) {
        this.baseModels = tables
        notifyDataSetChanged()
    }

}
