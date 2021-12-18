package com.ekyrizky.clean_mvvm_template.core.data.repository

import com.ekyrizky.clean_mvvm_template.core.data.source.remote.network.Response
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<RequestType, ResultType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)) {
            emit(Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is Response.Success -> {
                    saveCallResult(apiResponse.data)
                    emitAll(loadFromDB().map {
                        Resource.Success(it)
                    })
                }
                is Response.Empty -> {
                    emitAll(loadFromDB().map { Resource.Success(it) })
                }
                is Response.Error -> {
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.message))
                }
            }
        } else {
            emitAll(loadFromDB().map {
                Resource.Success(it)
            })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<Response<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Resource<ResultType>> = result
}