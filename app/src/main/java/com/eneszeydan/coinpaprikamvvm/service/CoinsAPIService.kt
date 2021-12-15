package com.eneszeydan.coinpaprikamvvm.service

import com.eneszeydan.coinpaprikamvvm.model.Coins
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class CoinsAPIService {

    private val BASE_URL = "https://api.coinpaprika.com/v1/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(CoinsAPI::class.java)

    fun getData() : Single<Coins> = api.getCoins()

}