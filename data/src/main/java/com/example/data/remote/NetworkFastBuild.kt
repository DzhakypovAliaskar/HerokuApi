package com.example.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class RetrofitClient @Inject constructor(){

    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit= Retrofit.Builder()
        .baseUrl("https://ghibliapi.herokuapp.com/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

class OkHttp @Inject constructor(){
     fun provideOkHttpClient() : OkHttpClient{
         val client = OkHttpClient()
             .newBuilder()
             .addInterceptor(provideLoggingInterceptor())
             .callTimeout(30,TimeUnit.SECONDS)
             .connectTimeout(30, TimeUnit.SECONDS)
             .readTimeout(30,TimeUnit.SECONDS)
             .writeTimeout(30, TimeUnit.SECONDS)
         return client.build()
     }

    private fun provideLoggingInterceptor() = HttpLoggingInterceptor().setLevel(
        when{
            else -> HttpLoggingInterceptor.Level.NONE
        }
    )
}