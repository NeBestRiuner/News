package ru.itmo.news.ViewModel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.itmo.news.API.Data.NewsResponse
import ru.itmo.news.API.RetrofitClient.apiService
import ru.itmo.news.Model.Article
import ru.itmo.news.Model.Source


class NewsViewModel:ViewModel() {
    val articles = mutableStateListOf<Article>()
    val article = mutableStateOf(Article(Source("",""),"","","","","","",""))
    fun sendNewsRequest(){
        val call = apiService.getNews("us","a6e5b787dd804a17810213b7b7212af2")
        call.enqueue(object: Callback<NewsResponse>{
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if(response.isSuccessful()) {
                    val result = response.body()
                    if (result != null) {
                        var i = 0
                        articles.removeAll(articles)
                        Log.d("TAG",articles.size.toString())
                        for(res in result.articles){
                            articles.add(res)
                            Log.d("TAG_counter",res.urlToImage.toString())
                            i++
                        }
                    }
                    Log.d("TAG",articles.size.toString())
                }else{

                }
            }
            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {

            }

        })
    }
}

