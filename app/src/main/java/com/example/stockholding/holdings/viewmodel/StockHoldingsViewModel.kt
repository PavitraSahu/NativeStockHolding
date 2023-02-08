package com.example.stockholding.holdings.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stockholding.api.ApiService
import com.example.stockholding.holdings.model.Data
import com.example.stockholding.holdings.model.StockHoldingsModel
import com.example.stockholding.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StockHoldingsViewModel @Inject constructor(private val getAppRepository: AppRepository) :
    ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
    get() = _isLoading

    private val _stockHoldings = MutableLiveData<StockHoldingsModel>()
    val stockHoldings: LiveData<StockHoldingsModel>
    get() = _stockHoldings

    private val _failureMsg = MutableLiveData<String>()
    val failureMsg: LiveData<String>
    get() = _failureMsg

    fun getStockHoldings() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val stockHoldings = getAppRepository.getStockHoldings()
                _isLoading.value = false
                if(stockHoldings.data.size>0){
                    _stockHoldings.value = stockHoldings;
                }
            }
            catch(e: Exception) {
                _failureMsg.value = e.message.toString()
            }
        }
    }
}