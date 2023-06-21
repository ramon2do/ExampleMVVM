package com.example.mvvm.data.network.client

import com.example.mvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET("/.json")
    suspend fun  findAll(): Response<List<QuoteModel>?>
}