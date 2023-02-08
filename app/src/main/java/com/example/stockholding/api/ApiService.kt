package com.example.stockholding.api

import com.example.stockholding.holdings.model.StockHoldingsModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("v3/6d0ad460-f600-47a7-b973-4a779ebbaeaf")
    suspend fun getStockHoldings(): StockHoldingsModel

//    companion object {
//        operator fun invoke() : ApiService{
//            return Retrofit.Builder().baseUrl("https://run.mocky.io/")
//                .addConverterFactory(GsonConverterFactory.create()).build()
//                .create(ApiService::class.java)
//        }
//    }
}