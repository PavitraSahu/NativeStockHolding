package com.example.stockholding.repository

import com.example.stockholding.api.ApiService

class AppRepository(val apiService: ApiService) {

    suspend fun getStockHoldings() = apiService.getStockHoldings()
}