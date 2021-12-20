package com.eneszeydan.coinpaprikamvvm.util

import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable

fun placeholderProgressBar(context: Context) : CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}