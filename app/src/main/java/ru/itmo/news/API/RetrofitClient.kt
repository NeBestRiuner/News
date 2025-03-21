package ru.itmo.news.API

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    val BASE_URL="https://newsapi.org/"
    val apiService : APIService by lazy{
        val logging = HttpLoggingInterceptor().apply{
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(logging).build()
        Retrofit.Builder().baseUrl(BASE_URL).client(client).
        addConverterFactory(GsonConverterFactory.create()).build().create(APIService::class.java)
    }
}