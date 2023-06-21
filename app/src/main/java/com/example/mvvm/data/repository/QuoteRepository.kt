package com.example.mvvm.data.repository

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.network.service.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val provider: QuoteProvider
) {
    suspend fun finAllQuotes(): List<QuoteModel>? {
        val response = api.findQuotes()
        provider.quotes = response ?: emptyList()
        return response
    }
}