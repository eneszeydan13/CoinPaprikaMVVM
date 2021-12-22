package com.eneszeydan.coinpaprikamvvm.service

import com.eneszeydan.coinpaprikamvvm.model.Coins
import io.reactivex.Single
import retrofit2.http.GET

interface CoinsAPI {

    //I used single because I don't expect changes in the data I am getting
    //Single will return an onSuccess or onError
    @GET("coins")
    fun getCoins():Single<Coins>
}