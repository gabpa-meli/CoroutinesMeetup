package com.gabcode.coroutinesmeet.data

import java.lang.Exception

sealed class ResultData<out T> {
    data class Success<out T>(val data: T): ResultData<T>()
    data class Error(val failure: Exception) : ResultData<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[failure=$failure]"
        }
    }
}