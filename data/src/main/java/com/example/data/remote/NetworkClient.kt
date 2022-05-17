package com.example.data.remote

import com.example.data.remote.apisevise.AnimeApi
import retrofit2.Retrofit
import javax.inject.Inject

class NetworkClient @Inject constructor(
    retrofitClient : RetrofitClient,
    okHttp: OkHttp
){
    private val provideRetrofit = retrofitClient.provideRetrofit(okHttp.provideOkHttpClient())

    fun provideAnimeApiService() : AnimeApi = provideRetrofit.create()

    inline fun <reified T : Any> Retrofit.create() : T = create(T::class.java)
}