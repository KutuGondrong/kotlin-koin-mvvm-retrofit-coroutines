package com.kutugondrong.hci.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import com.kutugondrong.hci.R
import com.kutugondrong.hci.model.Data

class MainAdapter(private val data: Data.DataResponse, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType> = ArrayList()
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()

    init {
        saveDataToViewTypeBySection()
        delegateAdapters.put(AdapterConstants.PRODUCT, ProductDelegateAdapter())
        delegateAdapters.put(AdapterConstants.TITLE, TitleDelegateAdapter())
        delegateAdapters.put(AdapterConstants.ARTICLE, ArticleDelegateAdapter())
    }

    private fun saveDataToViewTypeBySection() {
        for (item in data.data) {
            if (item.section == AdapterConstants.PRODUCT_STR) {
                val productItem = object : ViewType {
                    override fun getViewType() = AdapterConstants.PRODUCT
                    override fun getData(): Data.SectionResponse {
                        return item
                    }
                }
                items.add(0,productItem)
            } else if (item.section == AdapterConstants.ARTICLE_STR) {
                val titleItem = object : ViewType{
                    override fun getViewType() = AdapterConstants.TITLE
                    override fun getData(): String {
                        return context.resources.getString(R.string.title_article)
                    }
                }
                items.add(titleItem)
                for (data in item.items) {
                    val articleItem = object : ViewType{
                        override fun getViewType() = AdapterConstants.ARTICLE
                        override fun getData(): Data.ItemResponse {
                            return data
                        }
                    }
                    items.add(articleItem)
                }
            }
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        delegateAdapters.get(viewType)!!.onCreateViewHolder(parent)


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position))?.onBindViewHolder(holder, items[position])
    }

    override fun getItemViewType(position: Int) = items[position].getViewType()


}