package com.example.script.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookEntity::class], version = 1)
abstract class ScriptDatabase : RoomDatabase() {
    abstract fun bookDao(): BookDao
}
