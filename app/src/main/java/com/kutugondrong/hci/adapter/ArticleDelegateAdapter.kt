package com.kutugondrong.hci.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kutugondrong.hci.R
import com.kutugondrong.hci.model.Data
import kotlinx.android.synthetic.main.article_items_layout.view.*

class ArticleDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ArticleHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as ArticleHolder
        holder.bind(item.getData() as Data.ItemResponse)
    }


    inner class ArticleHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.article_items_layout, parent, false)) {

        fun bind(item: Data.ItemResponse) {
            itemView.txtTitle.text = item.article_title
            Glide.with(itemView.context).load(item.article_image).into(itemView.imgArticle)
        }
    }
}