package com.kutugondrong.hci.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kutugondrong.hci.R
import com.kutugondrong.hci.model.Data

class ProductAdapter(private val dataSet: List<Data.ItemResponse>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val view: View = v
        val txtTitle: TextView = view.findViewById(R.id.txtTitle)
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.product_item_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.txtTitle.text = dataSet[position].product_name
        Glide.with(viewHolder.view.context).load(dataSet[position].product_image).into(viewHolder.imgProduct)
    }

    override fun getItemCount() = dataSet.size

}
