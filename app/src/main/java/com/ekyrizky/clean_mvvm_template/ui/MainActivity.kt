package com.ekyrizky.clean_mvvm_template.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.ekyrizky.clean_mvvm_template.R
import com.ekyrizky.clean_mvvm_template.core.data.repository.Resource
import com.ekyrizky.clean_mvvm_template.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.post.observe(this) { resource ->
            when (resource) {
//                is Resource.Loading -> view loading
                is Resource.Success -> {
                    Log.d("MainActivity", "data: ${resource.data}")
                }
//                is Resource.Error -> error message
            }
        }
    }
}