package com.example.mvvm.data.db.entities

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.example.mvvm.domain.model.Quote

@Entity(tableName = "quotes_table")
class QuoteEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int = 0,
    @ColumnInfo(name = "quote") val quote: String,
    @ColumnInfo(name = "author") val author: String
)

fun Quote.toDatabase() = QuoteEntity(quote= quote, author = author)