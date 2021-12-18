package com.ekyrizky.clean_mvvm_template.core.data.repository

import com.ekyrizky.clean_mvvm_template.core.data.source.local.LocalDataSource
import com.ekyrizky.clean_mvvm_template.core.data.source.local.preferences.DataPreferences
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.RemoteDataSource
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.network.Response
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.response.PostResponse
import com.ekyrizky.clean_mvvm_template.core.domain.model.PostData
import com.ekyrizky.clean_mvvm_template.core.domain.repository.IRepository
import com.ekyrizky.clean_mvvm_template.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val remoteData: RemoteDataSource,
    private val localData: LocalDataSource,
    private val pref: DataPreferences
) : IRepository {

    override fun getPost(): Flow<Resource<List<PostData>>> {
        return object : NetworkBoundResource<List<PostResponse>, List<PostData>>() {
            override fun loadFromDB(): Flow<List<PostData>> {
                return localData.getPost().map {
                    DataMapper.mapPostEntityToPostData(it)
                }
            }

            override fun shouldFetch(data: List<PostData>?): Boolean {
                return data.isNullOrEmpty()
            }

            override suspend fun createCall(): Flow<Response<List<PostResponse>>> {
                return remoteData.getPost()
            }

            override suspend fun saveCallResult(data: List<PostResponse>) {
                val postList = DataMapper.mapPostResponseToPostEntity(data)
                localData.insertArticles(postList)
            }
        }.asFlow()
    }
}