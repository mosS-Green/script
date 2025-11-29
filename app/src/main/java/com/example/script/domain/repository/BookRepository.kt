package com.example.script.domain.repository

import com.example.script.domain.model.Book
import kotlinx.coroutines.flow.Flow

interface BookRepository {
    fun getAllBooks(): Flow<List<Book>>
    suspend fun getBookById(id: Int): Book?
    suspend fun insertBook(book: Book)
    suspend fun deleteBook(book: Book)
    suspend fun updateProgress(bookId: Int, progress: Float)
}
