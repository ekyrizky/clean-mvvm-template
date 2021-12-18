package com.ekyrizky.clean_mvvm_template.di

import com.ekyrizky.clean_mvvm_template.core.domain.usecase.Interactor
import com.ekyrizky.clean_mvvm_template.core.domain.usecase.UseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun providesUseCase(interactor: Interactor): UseCase
}