package ru.itmo.news.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import ru.itmo.news.MainActivity
import ru.itmo.news.Model.Article
import ru.itmo.news.ViewModel.NewsViewModel

@Composable
fun DescriptionNewsScreen(newsViewModel: NewsViewModel, article: Article,navController: NavController){
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.fillMaxWidth()){
            IconButton(onClick = { navController.navigate(MainActivity.Routes.Authorization.route) }) {
                Image(
                    imageVector = Icons.AutoMirrored.Default.ArrowBack,
                    contentDescription = "Стрелка назад"
                )
            }
        }
        AsyncImage(modifier = Modifier.size(200.dp),model = article.urlToImage.toString(), contentDescription = "article image")
        Text(modifier = Modifier.padding(bottom = 20.dp), text = article.title.toString())
        Text(article.content.toString())
    }
}