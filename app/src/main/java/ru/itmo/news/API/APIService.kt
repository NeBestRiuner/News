package ru.itmo.news.API

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import ru.itmo.news.API.Data.NewsResponse

interface APIService {
    @GET("/v2/top-headlines/")
    fun getNews(@Query("country") country :String, @Query("apikey") apikey:String): Call<NewsResponse>
}