package com.example.mvvm.domain.usecase

import com.example.mvvm.data.db.entities.toDatabase
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.repository.QuoteRepository
import com.example.mvvm.domain.model.Quote
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.finAllQuotesFromApi()

        return if(quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuotes(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.finAllQuotesFromDatabase()
        }
    }
}