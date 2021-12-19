package com.eneszeydan.coinpaprikamvvm.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.eneszeydan.coinpaprikamvvm.model.Coins
import com.eneszeydan.coinpaprikamvvm.service.CoinsAPIService
import io.reactivex.disposables.CompositeDisposable

class CoinsListViewModel(application: Application):BaseViewModel(application) {

    private val coinsAPIService = CoinsAPIService()
    private val disposable =  CompositeDisposable()

    val coins = MutableLiveData<Coins>()


}