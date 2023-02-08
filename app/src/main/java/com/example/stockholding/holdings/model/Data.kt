package com.example.stockholding.holdings.model

import com.example.stockholding.utility.Utility

data class Data(
    val avg_price: String,
    val close: Double,
    val cnc_used_quantity: Int,
    val collateral_qty: Int,
    val collateral_type: String,
    val collateral_update_qty: Int,
    val company_name: String,
    val haircut: Double,
    val holdings_update_qty: Int,
    val isin: String,
    val ltp: Double,
    val product: String,
    val quantity: Int,
    val symbol: String,
    val t1_holding_qty: Int,
    val token_bse: String,
    val token_nse: String,
    val withheld_collateral_qty: Int,
    val withheld_holding_qty: Int
){
    fun getCurrentValue():Double{
//        return String.format("%.2f", ltp*quantity).toDouble()
        return Utility.roundOfValuesToTwoDecimal(ltp*quantity)!!
    }

    fun getInvestedValue():Double{
//        return String.format("%.2f", avg_price.toDouble() * quantity).toDouble()
        return Utility.roundOfValuesToTwoDecimal(avg_price.toDouble() * quantity)!!
    }

    fun getPnl():Double{
//        return String.format("%.2f", getCurrentValue()-getInvestedValue()).toDouble()
        return Utility.roundOfValuesToTwoDecimal(getCurrentValue()-getInvestedValue())!!
    }

    fun getTodaysPnL():Double{
//        return String.format("%.2f", ((close-ltp)*quantity)).toDouble()
        return Utility.roundOfValuesToTwoDecimal(((close-ltp)*quantity))!!
    }

}