package com.example.script.domain.model

data class Book(
    val id: Int = 0,
    val title: String,
    val content: String,
    val progress: Float = 0f, // 0.0 to 1.0
    val dateAdded: Long = System.currentTimeMillis()
)
