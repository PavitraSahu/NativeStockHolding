package com.example.stockholding.utility

import android.content.Context
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.TextAppearanceSpan
import com.example.stockholding.holdings.model.Data
import java.math.RoundingMode
import java.text.DecimalFormat

object Utility {

    fun styleHoldingLtp(context: Context, s:String):String{
        val str = "LTP: "+ appendRupeeSymbol(s)
        val sb = SpannableString(str)
        val styleSpan = TextAppearanceSpan(context, android.graphics.Typeface.BOLD)
        sb.setSpan(styleSpan, 5, str.length-1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        return sb.toString();
    }

    fun styleHoldingPnl(context:Context, s:String):String{
        val str = "P/L: "+ appendRupeeSymbol(s)
        val sb = SpannableString(str)
        val styleSpan = TextAppearanceSpan(context, android.graphics.Typeface.BOLD)
        sb.setSpan(styleSpan, 5, str.length-1, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

        return sb.toString();
    }

    fun appendRupeeSymbol(s:String):String{
        return "\u20B9$s"
    }

    fun roundOfValuesToTwoDecimal(value: Double):Double?{
        val df = DecimalFormat("#.00")
        df.roundingMode = RoundingMode.HALF_UP
        return df.format(value).toDouble()
    }
}