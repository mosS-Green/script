package com.example.script.ui.reader

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.script.domain.model.Book
import com.example.script.domain.repository.BookRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReaderViewModel @Inject constructor(
    private val bookRepository: BookRepository
) : ViewModel() {

    private val _book = MutableStateFlow<Book?>(null)
    val book: StateFlow<Book?> = _book.asStateFlow()

    fun loadBook(bookId: Int) {
        viewModelScope.launch {
            _book.value = bookRepository.getBookById(bookId)
        }
    }

    fun updateProgress(progress: Float) {
        val currentBook = _book.value ?: return
        viewModelScope.launch {
            bookRepository.updateProgress(currentBook.id, progress)
        }
    }
}
