package com.example.script.data.repository

import com.example.script.data.local.BookDao
import com.example.script.data.local.toDomain
import com.example.script.data.local.toEntity
import com.example.script.domain.model.Book
import com.example.script.domain.repository.BookRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val bookDao: BookDao
) : BookRepository {

    override fun getAllBooks(): Flow<List<Book>> {
        return bookDao.getAllBooks().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getBookById(id: Int): Book? {
        return bookDao.getBookById(id)?.toDomain()
    }

    override suspend fun insertBook(book: Book) {
        bookDao.insertBook(book.toEntity())
    }

    override suspend fun deleteBook(book: Book) {
        bookDao.deleteBook(book.toEntity())
    }

    override suspend fun updateProgress(bookId: Int, progress: Float) {
        bookDao.updateProgress(bookId, progress)
    }
}
