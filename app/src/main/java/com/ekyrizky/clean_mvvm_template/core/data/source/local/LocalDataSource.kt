package com.ekyrizky.clean_mvvm_template.core.data.source.local

import com.ekyrizky.clean_mvvm_template.core.data.source.local.entity.PostEntity
import com.ekyrizky.clean_mvvm_template.core.data.source.local.room.DataDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val dataDao: DataDao) {

    fun getPost(): Flow<List<PostEntity>> {
        return dataDao.getPost()
    }

    suspend fun insertArticles(post: List<PostEntity>) {
        return dataDao.insertPost(post)
    }
}