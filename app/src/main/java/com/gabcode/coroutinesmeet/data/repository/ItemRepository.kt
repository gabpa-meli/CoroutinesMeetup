package com.gabcode.coroutinesmeet.data.repository

import com.gabcode.coroutinesmeet.data.ResultData
import com.gabcode.coroutinesmeet.data.local.Item
import com.gabcode.coroutinesmeet.data.local.SearchResult

interface ItemRepository {

    suspend fun searchQuery(query: String, offset: Int = 0): ResultData<SearchResult<Item>>

    suspend fun getItem(id: String): ResultData<Item>
}