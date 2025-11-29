package com.example.script.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.script.domain.model.Book

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val progress: Float,
    val dateAdded: Long
)

fun BookEntity.toDomain(): Book {
    return Book(
        id = id,
        title = title,
        content = content,
        progress = progress,
        dateAdded = dateAdded
    )
}

fun Book.toEntity(): BookEntity {
    return BookEntity(
        id = id,
        title = title,
        content = content,
        progress = progress,
        dateAdded = dateAdded
    )
}
