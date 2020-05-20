package com.gabcode.coroutinesmeet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabcode.coroutinesmeet.R
import com.gabcode.coroutinesmeet.ui.item.ItemActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this, ItemActivity::class.java))
    }

}
