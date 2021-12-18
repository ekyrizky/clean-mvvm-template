package com.ekyrizky.clean_mvvm_template.core.domain.repository

import com.ekyrizky.clean_mvvm_template.core.data.repository.Resource
import com.ekyrizky.clean_mvvm_template.core.domain.model.PostData
import kotlinx.coroutines.flow.Flow

interface IRepository {
    fun getPost(): Flow<Resource<List<PostData>>>
}