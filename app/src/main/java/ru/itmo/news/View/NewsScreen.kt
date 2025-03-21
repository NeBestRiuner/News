package ru.itmo.news.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import ru.itmo.news.MainActivity
import ru.itmo.news.Model.Article
import ru.itmo.news.R
import ru.itmo.news.ViewModel.NewsViewModel

@Composable
fun NewsScreen(modifier: Modifier = Modifier, navController: NavController, viewModel: NewsViewModel,
               articles: MutableList<Article>){

    Column(Modifier.fillMaxSize()){
        Row(Modifier.fillMaxWidth()){
            IconButton(onClick = { navController.navigate(MainActivity.Routes.Authorization.route) }) {
                Image(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Стрелка назад"
                )
            }
        }
        LazyColumn {
            items(articles){
                article ->
                    NewsArticle(article, newsViewModel = viewModel, navController)
            }
        }
    }
}
@Composable
fun NewsArticle(article: Article, newsViewModel: NewsViewModel, navController: NavController){
    Surface(onClick = {newsViewModel.article.value=article
        navController.navigate(MainActivity.Routes.Description.route)
    }) {
        Row(Modifier.fillMaxWidth().padding(bottom = 50.dp)) {
            AsyncImage(
                modifier = Modifier.size(200.dp),
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(article.urlToImage).build(),
                contentDescription = "Изображение к новости"
            )
            Column() {
                Text(modifier = Modifier.padding(bottom = 20.dp), text = article.title.toString())
                Text(article.description.toString())
            }
        }
    }
}