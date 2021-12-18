package com.ekyrizky.clean_mvvm_template.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ekyrizky.clean_mvvm_template.core.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCase: UseCase) : ViewModel() {

    val post = useCase.getPost().asLiveData()
}