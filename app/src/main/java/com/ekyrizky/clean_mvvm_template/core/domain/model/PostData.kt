package com.ekyrizky.clean_mvvm_template.core.domain.model

data class PostData(
    var id: Int?,
    val userId: Int?,
    var title: String?,
    val body: String?
)