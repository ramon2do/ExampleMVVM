package com.example.mvvm.domain.usecase

import com.example.mvvm.data.repository.QuoteRepository
import com.example.mvvm.domain.model.Quote
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): Quote? {
        val quotes = repository.finAllQuotesFromDatabase()

        if(quotes.isNotEmpty()) {
            val randomNumber = quotes.indices.random()
            return quotes[randomNumber]
        }
        return null
    }
}