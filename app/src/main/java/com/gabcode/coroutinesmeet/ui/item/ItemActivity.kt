package com.gabcode.coroutinesmeet.ui.item

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gabcode.coroutinesmeet.R
import com.gabcode.coroutinesmeet.data.local.Item

class ItemActivity : AppCompatActivity(), ItemContract.View {

    private val TAG = ItemActivity::class.java.simpleName

    private var presenter: ItemPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        presenter = ItemPresenter(this)
        presenter?.fetchItems("barbijo")
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.onCleared()
    }

    override fun showDataItem(item: Item) {
        Log.i(TAG, "item:$item")
    }

    override fun showDataSearch(items: List<Item>) {
        if (!items.isNullOrEmpty()) {
            Log.i(TAG, "items:$items")
            presenter?.fetchItem(items[0].id)
        }
    }

    override fun showError() {
        Log.i(TAG, "Error")
    }
}
