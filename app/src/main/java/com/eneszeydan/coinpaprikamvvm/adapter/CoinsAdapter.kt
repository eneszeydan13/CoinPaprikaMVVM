package com.eneszeydan.coinpaprikamvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.eneszeydan.coinpaprikamvvm.R
import com.eneszeydan.coinpaprikamvvm.databinding.CoinsListRowBinding
import com.eneszeydan.coinpaprikamvvm.model.Coins

class CoinsAdapter(private val coins: Coins): RecyclerView.Adapter<CoinsAdapter.ViewHolder>(){
    class ViewHolder(var view: CoinsListRowBinding): RecyclerView.ViewHolder(view.root){
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<CoinsListRowBinding>(inflater, R.layout.coins_list_row, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.coin = coins[position]
    }

    override fun getItemCount(): Int {
        return coins.size
    }

    fun updateCoinsList(newCoinsList : Coins){
        coins.addAll(newCoinsList)
        notifyDataSetChanged()
    }


}