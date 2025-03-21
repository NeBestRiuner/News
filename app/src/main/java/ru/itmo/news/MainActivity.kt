package ru.itmo.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.itmo.news.View.AuthorizationScreen
import ru.itmo.news.View.DescriptionNewsScreen
import ru.itmo.news.View.NewsScreen
import ru.itmo.news.ViewModel.AuthorizationViewModel
import ru.itmo.news.ViewModel.NewsViewModel
import ru.itmo.news.ui.theme.NewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsTheme {
                val navController = rememberNavController()
                val newsViewModel: NewsViewModel = NewsViewModel()
                val authorizationViewModel = AuthorizationViewModel()
                NavHost(navController, startDestination = "authorize"){
                    composable(Routes.Authorization.route){
                        AuthorizationScreen(navController = navController,
                            newsViewModel = newsViewModel)
                    }
                    composable(Routes.News.route){
                        NewsScreen(navController = navController, viewModel = newsViewModel,
                            articles = newsViewModel.articles)
                    }
                    composable(Routes.Description.route){
                        DescriptionNewsScreen(newsViewModel,
                            article = newsViewModel.article.value,navController)
                    }
                }
            }
        }
    }
    sealed class Routes(val route: String){
        object Authorization: Routes("authorize")
        object News: Routes("news")
        object Description: Routes("description")
    }
}


