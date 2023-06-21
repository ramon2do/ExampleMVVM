package com.example.mvvm.domain

import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.data.repository.QuoteRepository
import javax.inject.Inject

class GetQuotesUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke(): List<QuoteModel>? = repository.finAllQuotes()
}