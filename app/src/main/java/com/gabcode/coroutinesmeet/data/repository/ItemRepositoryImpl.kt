package com.gabcode.coroutinesmeet.data.repository

import com.gabcode.coroutinesmeet.data.ResultData
import com.gabcode.coroutinesmeet.data.local.Item
import com.gabcode.coroutinesmeet.data.local.SearchResult
import com.gabcode.coroutinesmeet.data.mapToModel
import com.gabcode.coroutinesmeet.data.remote.ApiService
import com.gabcode.coroutinesmeet.data.remote.RestClient
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

class ItemRepositoryImpl(private val dispatcher: CoroutineDispatcher) : ItemRepository {

    private val service: ApiService = RestClient.createService(ApiService::class.java)

    override suspend fun searchQuery(query: String, offset: Int): ResultData<SearchResult<Item>> {
        return safeRequest(dispatcher, { service.search(query, offset) }, { it.mapToModel() })
    }

    override suspend fun getItem(id: String): ResultData<Item> {
        return safeRequest(dispatcher, { service.getItem(id) }, { it.mapToModel() })
    }

    private suspend fun <T,R> safeRequest(
        dispatcher: CoroutineDispatcher, call: suspend () -> Response<T>, transform: (T) -> R): ResultData<R> {
        return withContext(dispatcher) {
            try {
                val response = call.invoke()
                when (response.isSuccessful) {
                    true -> ResultData.Success(transform(response.body()!!))
                    false -> throw HttpException(response)
                }
            } catch (exception: Exception) {
                ResultData.Error(exception)
            }
        }
    }
}
