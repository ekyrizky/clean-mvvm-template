package com.ekyrizky.clean_mvvm_template.core.data.source.local.room

import androidx.room.*
import androidx.room.Dao
import com.ekyrizky.clean_mvvm_template.core.data.source.local.entity.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Query("SELECT * FROM post")
    fun getPost(): Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPost(data: List<PostEntity>)
}