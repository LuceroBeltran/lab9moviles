package com.example.lab09

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModelProvider

class PostViewModel(private val service: PostApiService) : ViewModel() {

    // State para manejar la lista de posts
    private val _posts = mutableStateOf<List<PostModel>>(emptyList())
    val posts: State<List<PostModel>> = _posts

    // State para manejar un único post
    private val _post = mutableStateOf<PostModel?>(null)
    val post: State<PostModel?> = _post

    // Método para obtener la lista de posts
    fun fetchPosts() {
        viewModelScope.launch {
            val result = service.getUserPosts()
            _posts.value = result
        }
    }

    // Método para obtener un post por id
    fun fetchPostById(id: Int) {
        viewModelScope.launch {
            val result = service.getUserPostById(id)
            _post.value = result
        }
    }
}
