package com.example.mvvm.data.network.service

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.network.client.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {
    suspend fun findQuotes(): List<QuoteModel>? {
        return withContext(Dispatchers.IO) {
            val response = api.findAll()
            response.body() ?: emptyList()
        }
    }
}