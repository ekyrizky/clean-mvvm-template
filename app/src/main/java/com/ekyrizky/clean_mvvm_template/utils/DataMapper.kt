package com.ekyrizky.clean_mvvm_template.utils

import com.ekyrizky.clean_mvvm_template.core.data.source.local.entity.PostEntity
import com.ekyrizky.clean_mvvm_template.core.data.source.remote.response.PostResponse
import com.ekyrizky.clean_mvvm_template.core.domain.model.PostData

object DataMapper {

    fun mapPostEntityToPostData(input: List<PostEntity>): List<PostData> {
        return input.map {
            PostData(
                id = it.id,
                userId = it.userId,
                title = it.title,
                body = it.body
            )
        }
    }

    fun mapPostResponseToPostEntity(input: List<PostResponse>): List<PostEntity> {
        return input.map {
            PostEntity(
                id = it.id,
                userId = it.userId,
                title = it.title,
                body = it.body
            )
        }
    }
}