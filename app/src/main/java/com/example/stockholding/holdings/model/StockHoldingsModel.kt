package com.example.stockholding.holdings.model

import com.example.stockholding.utility.Utility

data class StockHoldingsModel(
    val client_id: String,
    val `data`: ArrayList<Data>,
    val error: Any,
    val response_type: String,
    val timestamp: Long
) {
    fun getSummary():Summary{
        var cv = 0.0
        var iv = 0.0
        var todaysProfit = 0.0
        var totalProfit = 0.0

        for(d in data){
            cv +=d.getCurrentValue()
            iv +=d.getInvestedValue()
            todaysProfit +=d.getTodaysPnL()
        }

        totalProfit = cv-iv;

        cv = Utility.roundOfValuesToTwoDecimal(cv)!!
        iv = Utility.roundOfValuesToTwoDecimal(iv)!!
        todaysProfit = Utility.roundOfValuesToTwoDecimal(todaysProfit)!!
        totalProfit = Utility.roundOfValuesToTwoDecimal(totalProfit)!!

        return Summary(cv, iv, todaysProfit, totalProfit);
    }
}

data class Summary(val totalCurrentValue:Double,
                    val totalInvestedValue: Double,
                    val todaysProfit: Double,
                    val totalProfit:Double)
