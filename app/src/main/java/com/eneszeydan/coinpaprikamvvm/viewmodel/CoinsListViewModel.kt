package com.eneszeydan.coinpaprikamvvm.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.eneszeydan.coinpaprikamvvm.model.Coins
import com.eneszeydan.coinpaprikamvvm.service.CoinsAPIService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class CoinsListViewModel(application: Application):BaseViewModel(application) {

    private val coinsAPIService = CoinsAPIService()
    private val disposable =  CompositeDisposable()

    val coins = MutableLiveData<Coins>()

    fun getDataFromAPI(){
        launch {
            disposable.add(
                coinsAPIService.getData()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribeWith(object : DisposableSingleObserver<Coins>(){
                        override fun onSuccess(t: Coins) {
                            coins.value = t
                            print(coins.value!![1].id)
                            Log.i("getData","Success!")
                        }

                        override fun onError(e: Throwable) {
                            Log.w("Error",e.localizedMessage!!)
                        }

                    })
            )
        }

    }

}