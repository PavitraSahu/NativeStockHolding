package com.example.stockholding.holdings.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.stockholding.databinding.FragmentStockholdingBinding
import com.example.stockholding.holdings.model.Data
import com.example.stockholding.holdings.model.StockHoldingsModel
import com.example.stockholding.holdings.model.adapter.HoldingsRecyclerViewAdapter
import com.example.stockholding.holdings.viewmodel.StockHoldingsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StockHoldingFragment : Fragment() {

    private var _binding: FragmentStockholdingBinding? = null
    private val stockHoldingsViewModel: StockHoldingsViewModel by viewModels()
    private val holdingsRecyclerViewAdapter = HoldingsRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStockholdingBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        stockHoldingsViewModel.getStockHoldings()

        observeViewModelData()
    }

    private fun observeViewModelData(){
        stockHoldingsViewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if (isLoading)
                _binding!!.progressBar.visibility = View.VISIBLE
            else
                _binding!!.progressBar.visibility = View.GONE
        })

        stockHoldingsViewModel.stockHoldings.observe(viewLifecycleOwner, Observer { holdings ->
            holdingsRecyclerViewAdapter!!.addItems(holdings.data)
            _binding!!.data = holdings
        })
    }

    private fun initView() {
        _binding!!.holdingRecyclerView.apply {
            setHasFixedSize(false)
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = holdingsRecyclerViewAdapter
        }
    }
}