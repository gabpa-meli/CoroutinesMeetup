package com.gabcode.coroutinesmeet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabcode.coroutinesmeet.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        initCoroutine()
    }

    private fun initCoroutine() {
        GlobalScope.launch {  welcome() }
    }

    private

    suspend fun welcome() = coroutineScope {
        launch {
            delay(1000)
            print("Kotlin Coroutines")
        }
        print("Welcome to:")
    }


}
