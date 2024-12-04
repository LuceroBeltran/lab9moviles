package com.example.lab09

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class PostViewModelFactory(private val service: PostApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PostViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PostViewModel(service) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

