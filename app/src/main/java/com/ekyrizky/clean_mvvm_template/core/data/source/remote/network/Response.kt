package com.ekyrizky.clean_mvvm_template.core.data.source.remote.network

sealed class Response<out T> {
    object Empty : Response<Nothing>()

    data class Success<out T>(
        val data: T
    ) : Response<T>()

    data class Error(
        val message: String
    ) : Response<Nothing>()
}