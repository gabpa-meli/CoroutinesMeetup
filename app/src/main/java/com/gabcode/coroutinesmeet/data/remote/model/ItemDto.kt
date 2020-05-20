package com.gabcode.coroutinesmeet.data.remote.model

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Double,
    @SerializedName("currency_id") val currency: String,
    @SerializedName("thumbnail") val thumbnail: String,
    @SerializedName("available_quantity") val availableQuantity: Int,
    @SerializedName("condition") val condition: String,
    @SerializedName("pictures") val pictures: List<PictureDto>
)

data class PictureDto(
    @SerializedName("id") val id: String,
    @SerializedName("url") val url: String,
    @SerializedName("size") val size: String,
    @SerializedName("max_size") val maxSize: String
)