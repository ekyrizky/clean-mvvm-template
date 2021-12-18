package com.ekyrizky.clean_mvvm_template.core.domain.usecase

import com.ekyrizky.clean_mvvm_template.core.data.repository.Resource
import com.ekyrizky.clean_mvvm_template.core.domain.model.PostData
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun getPost(): Flow<Resource<List<PostData>>>
}