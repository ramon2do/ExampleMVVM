package com.example.mvvm.data.repository

import com.example.mvvm.data.db.dao.QuoteDao
import com.example.mvvm.data.db.entities.QuoteEntity
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.service.QuoteService
import com.example.mvvm.domain.model.Quote
import com.example.mvvm.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val dao: QuoteDao
) {
    suspend fun finAllQuotesFromApi(): List<Quote> {
        val response = api.finAllQuotes()
        return response?.map { it.toDomain() } ?: emptyList()
    }

    suspend fun finAllQuotesFromDatabase(): List<Quote> {
        val response = dao.finAllQuotes()
        return response?.map { it.toDomain() } ?: emptyList()
    }

    suspend fun insertQuotes(quotes: List<QuoteEntity>) {
        dao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        dao.deleteAllQuotes()
    }
}