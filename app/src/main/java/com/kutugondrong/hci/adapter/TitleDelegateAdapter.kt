package com.kutugondrong.hci.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kutugondrong.hci.R
import kotlinx.android.synthetic.main.title_item_layout.view.*

class TitleDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ArticleHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ArticleHolder
        holder.bind(item.getData() as String)
    }

    inner class ArticleHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.title_item_layout, parent, false)) {

        fun bind(item: String) {
            itemView.txtTitle.text = item
        }
    }
}