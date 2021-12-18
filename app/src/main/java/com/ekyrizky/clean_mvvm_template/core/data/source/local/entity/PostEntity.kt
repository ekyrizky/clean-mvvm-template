package com.ekyrizky.clean_mvvm_template.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "post")
data class PostEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var id: Int?,

    @ColumnInfo(name = "userId")
    val userId: Int?,

    @ColumnInfo(name = "title")
    var title: String?,

    @ColumnInfo(name = "body")
    val body: String?
)