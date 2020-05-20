package com.gabcode.coroutinesmeet.data.remote

import com.gabcode.coroutinesmeet.data.remote.model.ItemDto
import com.gabcode.coroutinesmeet.data.remote.model.SearchResultDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("sites/MLA/search")
    suspend fun search(
        @Query("q", encoded = true) query: String,
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 5
    ): Response<SearchResultDto<ItemDto>>

    @GET("items/{itemId}")
    suspend fun getItem(@Path("itemId") itemId: String): Response<ItemDto>
}