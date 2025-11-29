package com.example.script.di

import android.content.Context
import androidx.room.Room
import com.example.script.data.local.BookDao
import com.example.script.data.local.ScriptDatabase
import com.example.script.data.repository.BookRepositoryImpl
import com.example.script.domain.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideScriptDatabase(@ApplicationContext context: Context): ScriptDatabase {
        return Room.databaseBuilder(
            context,
            ScriptDatabase::class.java,
            "script_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideBookDao(database: ScriptDatabase): BookDao {
        return database.bookDao()
    }

    @Provides
    @Singleton
    fun provideBookRepository(bookDao: BookDao): BookRepository {
        return BookRepositoryImpl(bookDao)
    }
}
