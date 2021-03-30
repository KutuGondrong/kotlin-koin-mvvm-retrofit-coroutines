package com.kutugondrong.hci.model

import com.google.gson.annotations.SerializedName

class Data {
    data class DataResponse(
        @SerializedName("data")
        val data: List<SectionResponse>
    )

    data class SectionResponse(
        @SerializedName("section")
        val section: String,
        @SerializedName("section_title")
        val section_title: String,
        @SerializedName("items")
        val items: List<ItemResponse>
    )

    data class ItemResponse(
        @SerializedName("article_title")
        val article_title: String,
        @SerializedName("article_image")
        val article_image: String,
        @SerializedName("link")
        val link: String,
        @SerializedName("product_name")
        val product_name: String,
        @SerializedName("product_image")
        val product_image: String
    )
}