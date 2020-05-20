package com.gabcode.coroutinesmeet.data.local

import com.gabcode.coroutinesmeet.extension.empty

data class Item(
    val id: String,
    val title: String,
    val price: Double = 0.0,
    val currency: String = String.empty(),
    val thumbnail: String = String.empty(),
    val availableQuantity: Int = 0,
    val condition: String = String.empty(),
    val pictures: List<Picture> = listOf()
) {
    companion object {
        fun empty() = Item(
            String.empty(), String.empty(), 0.0, String.empty(), String.empty(),
            0, String.empty(), listOf())
    }
}

data class Picture(
    val id: String,
    val url: String
)


