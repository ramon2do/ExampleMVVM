package com.example.mvvm.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvm.data.db.dao.QuoteDao
import com.example.mvvm.data.db.entities.QuoteEntity

@Database(entities = [QuoteEntity::class], version = 1)
abstract class QuoteDatabase: RoomDatabase() {
    abstract fun getQuoteDao(): QuoteDao
}