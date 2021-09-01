package com.mb.soccerleauge.api

import android.content.Context
import com.mb.soccerleauge.utils.Constant.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private var _api: SoccerLeaugeApi? = null

// Accessing this will crash if done before calling generate()
val api get() = _api!!

fun generateApi(context: Context) {
    if (_api != null) return

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    _api = retrofit.create(SoccerLeaugeApi::class.java)
}