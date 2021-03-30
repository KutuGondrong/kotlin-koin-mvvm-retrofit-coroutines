package com.kutugondrong.hci.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kutugondrong.hci.R
import com.kutugondrong.hci.model.Data
import kotlinx.android.synthetic.main.product_layout.view.*


class ProductDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ArticleHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ArticleHolder
        holder.bind(item.getData() as Data.SectionResponse)
    }


    inner class ArticleHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.product_layout, parent, false)) {

        fun bind(item: Data.SectionResponse) {
            itemView.rv_data.apply {
                layoutManager = GridLayoutManager(itemView.context, 3)
                adapter = ProductAdapter(item.items)
            }
        }
    }
}