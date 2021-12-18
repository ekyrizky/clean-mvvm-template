package com.ekyrizky.clean_mvvm_template.di

import com.ekyrizky.clean_mvvm_template.core.data.repository.Repository
import com.ekyrizky.clean_mvvm_template.core.domain.repository.IRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesRepository(repository: Repository): IRepository
}