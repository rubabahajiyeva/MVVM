package com.rubabe.examplemvvmapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    fun getRetrofit(): IApi {
        val retofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://run.mocky.io/v3/").build()
        return retofit.create(IApi::class.java)
    }

}