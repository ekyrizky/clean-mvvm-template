package com.ekyrizky.clean_mvvm_template.core.data.source.remote

import com.ekyrizky.clean_mvvm_template.core.data.source.remote.network.ApiService
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.network.Response
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.response.PostResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getPost(): Flow<Response<List<PostResponse>>> {
        return flow {
            try {
                val response = apiService.getPost()
                if (response.isNotEmpty()) {
                    emit(Response.Success(response))
                } else {
                    emit(Response.Empty)
                }
            } catch (e: Exception) {
                emit(Response.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}