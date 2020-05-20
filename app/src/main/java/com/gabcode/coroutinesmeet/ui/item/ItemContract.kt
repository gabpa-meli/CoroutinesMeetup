package com.gabcode.coroutinesmeet.ui.item

import com.gabcode.coroutinesmeet.data.local.Item
import com.gabcode.coroutinesmeet.data.local.SearchResult

interface ItemContract {

    interface View {
        fun showDataItem(item: Item)
        fun showDataSearch(items: List<Item>)
        fun showError()
    }

    interface Presenter {
        fun fetchItems(query: String)
        fun fetchItem(id: String)
        fun fetchItemAsync(id: String)
    }
}