package com.ekyrizky.clean_mvvm_template.core.domain.usecase

import com.ekyrizky.clean_mvvm_template.core.data.repository.Resource
import com.ekyrizky.clean_mvvm_template.core.domain.model.PostData
import com.ekyrizky.clean_mvvm_template.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Interactor @Inject constructor(private val repository: IRepository) : UseCase {
    override fun getPost(): Flow<Resource<List<PostData>>> {
        return repository.getPost()
    }
}