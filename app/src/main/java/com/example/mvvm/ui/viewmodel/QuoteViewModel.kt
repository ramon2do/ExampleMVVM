package com.example.mvvm.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm.data.model.QuoteModel
import com.example.mvvm.domain.model.Quote
import com.example.mvvm.domain.usecase.GetQuotesUseCase
import com.example.mvvm.domain.usecase.GetRandomQuoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase: GetQuotesUseCase,
    private val getRandomQuoteUseCase: GetRandomQuoteUseCase
): ViewModel() {
    val quoteModel = MutableLiveData<Quote?>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(result.isNotEmpty()) {
                quoteModel.postValue(result.first())
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val quote = getRandomQuoteUseCase()

            if (quote != null) {
                quoteModel.postValue(quote)
            }

            isLoading.postValue(false)
        }
    }
}