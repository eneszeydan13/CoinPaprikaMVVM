package com.eneszeydan.coinpaprikamvvm.service

import com.eneszeydan.coinpaprikamvvm.model.Coins
import io.reactivex.Single
import retrofit2.http.GET

interface CoinsAPI {

    @GET("coins")
    fun getCoins():Single<Coins>
}