package com.ekyrizky.clean_mvvm_template.core.data.source.remote.network

import com.ekyrizky.clean_mvvm_template.core.data.source.remote.response.PostResponse
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPost(): List<PostResponse>
}