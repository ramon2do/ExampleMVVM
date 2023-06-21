package com.example.mvvm.data.repository

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.service.QuoteService

class QuoteRepository {
    private val api = QuoteService()

    suspend fun finAllQuotes(): List<QuoteModel>? {
        val response = api.findQuotes()
        QuoteProvider.quotes = response ?: emptyList()
        return response
    }
}