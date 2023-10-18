package com.example.aadityarepodummy.Utils

import com.example.aadityarepodummy.Interfaces.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    /*private val logger=HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHTTP=OkHttpClient.Builder().addInterceptor(logger)*/


    private const val BASE_URL = " https://fjc4bk0ppe.execute-api.ap-south-1.amazonaws.com/"
    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
