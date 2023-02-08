package com.example.stockholding.holdings.model.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholding.R
import com.example.stockholding.databinding.RecyclerviewStockholdingItemBinding
import com.example.stockholding.holdings.model.Data
import com.example.stockholding.utility.Utility

class HoldingsRecyclerViewAdapter() : RecyclerView.Adapter<HoldingsRecyclerViewAdapter.HoldingsViewHolder>() {

    var listOfHoldings = ArrayList<Data>()

    fun addItems(list: ArrayList<Data>) {
        listOfHoldings = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoldingsViewHolder {
        val binding = RecyclerviewStockholdingItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HoldingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HoldingsViewHolder, position: Int) {
        val item = listOfHoldings[position]
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return listOfHoldings.size
    }

    inner class HoldingsViewHolder(
        private val recyclerviewStockholdingItemBinding: RecyclerviewStockholdingItemBinding
    ) : RecyclerView.ViewHolder(recyclerviewStockholdingItemBinding.root) {

        fun bind(data: Data, position: Int) {
            recyclerviewStockholdingItemBinding.data = data
            recyclerviewStockholdingItemBinding.ltp.text = Utility.styleHoldingLtp(recyclerviewStockholdingItemBinding.root.context, data.ltp.toString())
            recyclerviewStockholdingItemBinding.pnl.text = Utility.styleHoldingPnl(recyclerviewStockholdingItemBinding.root.context, data.getPnl().toString())

            if (position==listOfHoldings.size-1)
                recyclerviewStockholdingItemBinding.dividerview.visibility = View.GONE
        }
    }
}