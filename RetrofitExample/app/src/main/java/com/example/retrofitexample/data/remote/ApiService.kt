package com.example.retrofitexample.data.remote

import com.example.retrofitexample.data.model.Post
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
