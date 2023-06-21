package com.example.mvvm.data.network.service

import com.example.mvvm.core.RetrofitHelper
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.network.client.QuoteApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class QuoteService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun findQuotes(): List<QuoteModel>? {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(QuoteApiClient::class.java).findAll()
            response.body() ?: emptyList()
        }
    }
}