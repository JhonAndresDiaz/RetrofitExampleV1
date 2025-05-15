package com.example.retrofitexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofitexample.data.model.Post
import com.example.retrofitexample.data.remote.RetrofitInstance
import kotlinx.coroutines.launch
import androidx.compose.runtime.*

class PostViewModel : ViewModel() {
    var posts = mutableStateListOf<Post>()
        private set

    var errorMessage by mutableStateOf("")

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getPosts()
                posts.addAll(response)
            } catch (e: Exception) {
                errorMessage = e.message ?: "Error desconocido"
            }
        }
    }
}
