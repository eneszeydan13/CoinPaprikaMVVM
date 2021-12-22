package com.eneszeydan.coinpaprikamvvm.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.eneszeydan.coinpaprikamvvm.R
import com.eneszeydan.coinpaprikamvvm.adapter.CoinsAdapter
import com.eneszeydan.coinpaprikamvvm.model.Coins
import com.eneszeydan.coinpaprikamvvm.viewmodel.CoinsListViewModel
import kotlinx.android.synthetic.main.fragment_coins_list.*


class CoinsListFragment : Fragment() {

    private lateinit var viewModel: CoinsListViewModel
    private val coinsAdapter = CoinsAdapter(Coins())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_coins_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = coinsAdapter

        viewModel = ViewModelProvider(this).get(CoinsListViewModel::class.java)
        viewModel.getDataFromAPI()
        observeLiveData()
    }

    private fun observeLiveData(){
        //Observer
        viewModel.coins.observe(viewLifecycleOwner, { coins ->
            coins?.let {
                coinsAdapter.updateCoinsList(it)
            }

        })
    }


}