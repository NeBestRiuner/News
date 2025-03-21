package ru.itmo.news.API.Data

import ru.itmo.news.Model.Article

data class NewsResponse(val status: String, val totalResults:Int, val articles: List<Article>)
