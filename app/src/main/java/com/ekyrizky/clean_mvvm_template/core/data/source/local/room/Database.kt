package com.ekyrizky.clean_mvvm_template.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ekyrizky.clean_mvvm_template.core.data.source.local.entity.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun dataDao(): DataDao
}