package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val provider: QuoteProvider
) {
    operator fun invoke(): QuoteModel? {
        val quotes = provider.quotes

        if(quotes.isNotEmpty()) {
            val randomNumber = quotes.indices.random()
            return quotes[randomNumber]
        }
        return null
    }
}