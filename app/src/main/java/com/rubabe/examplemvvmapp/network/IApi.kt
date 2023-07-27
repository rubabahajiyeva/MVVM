package com.rubabe.examplemvvmapp.network

import com.rubabe.examplemvvmapp.data.response.MovieItem
import retrofit2.Call
import retrofit2.http.GET

interface IApi {
    @GET("441e67f6-1997-4565-80dd-20483c06aca4")
    fun getMovies() : Call<List<MovieItem>>
}