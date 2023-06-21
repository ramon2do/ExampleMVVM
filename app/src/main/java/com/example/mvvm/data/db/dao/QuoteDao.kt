package com.example.mvvm.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvm.data.db.entities.QuoteEntity

@Dao
interface QuoteDao {
    @Query("SELECT * FROM quotes_table ORDER BY author DESC")
    suspend fun  finAllQuotes(): List<QuoteEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(quotes: List<QuoteEntity>)

    @Query("DELETE FROM quotes_table")
    suspend fun deleteAllQuotes()
}