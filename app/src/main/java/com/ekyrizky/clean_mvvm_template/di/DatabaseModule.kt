package com.ekyrizky.clean_mvvm_template.di

import android.content.Context
import androidx.room.Room
import com.ekyrizky.clean_mvvm_template.core.data.source.local.room.DataDao
import com.ekyrizky.clean_mvvm_template.core.data.source.local.room.Database
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, "Data.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesDataDao(database: Database): DataDao = database.dataDao()
}