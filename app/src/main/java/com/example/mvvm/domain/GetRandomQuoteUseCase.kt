package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import com.example.mvvm.data.repository.QuoteRepository

class GetRandomQuoteUseCase {
    private val repository = QuoteRepository()

    operator fun invoke(): QuoteModel? {
        val quotes = QuoteProvider.quotes

        if(quotes.isNotEmpty()) {
            val randomNumber = quotes.indices.random()
            return quotes[randomNumber]
        }
        return null
    }
}