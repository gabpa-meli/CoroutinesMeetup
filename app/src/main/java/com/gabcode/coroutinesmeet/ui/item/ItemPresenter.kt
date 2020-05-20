package com.gabcode.coroutinesmeet.ui.item

import com.gabcode.coroutinesmeet.data.ResultData
import com.gabcode.coroutinesmeet.data.repository.ItemRepositoryImpl
import kotlinx.coroutines.*
import com.gabcode.coroutinesmeet.data.local.Item

class ItemPresenter(private val view: ItemContract.View) : ItemContract.Presenter {

    private val scope = CoroutineScope(Dispatchers.Main)

    private val repository = ItemRepositoryImpl(Dispatchers.IO)

    override fun fetchItems(query: String) {
        scope.launch {
            when (val resultData = repository.searchQuery(query)) {
                is ResultData.Success -> view.showDataSearch(resultData.data.results)
                is ResultData.Error -> view.showError()
            }
        }
    }

    override fun fetchItem(id: String) {
        scope.launch {
            repository.getItem(id).let {resultData ->
                when (resultData) {
                    is ResultData.Success -> view.showDataItem(resultData.data)
                    is ResultData.Error -> view.showError()
                }
            }
        }
    }

    override fun fetchItemAsync(id: String) {
        scope.launch {
            when (val resultData = getItemResult(id)) {
                is ResultData.Success -> view.showDataItem(resultData.data)
                is ResultData.Error -> view.showError()
            }
        }
    }

    private suspend fun getItemResult(id: String): ResultData<Item> {
        return coroutineScope {
            val deferred = scope.async {
                repository.getItem(id)
            }

            deferred.await()
        }
    }

    fun onCleared() {
        scope.cancel()
    }
}