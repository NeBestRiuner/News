package ru.itmo.news.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController
import ru.itmo.news.MainActivity
import ru.itmo.news.ViewModel.NewsViewModel


@Composable
fun AuthorizationScreen(modifier: Modifier = Modifier, navController: NavController,
                        newsViewModel: NewsViewModel){
    var login = remember {  mutableStateOf("")}
    var password = remember { mutableStateOf("") }
    Column(modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally){
        TextField(value = login.value, onValueChange = { newText -> login.value = newText },
            label={Text("Логин")})
        TextField(value = password.value, onValueChange = { newText -> password.value = newText },
            label={Text("Пароль")})
        Button(onClick = {navController.navigate(MainActivity.Routes.News.route)
            newsViewModel.sendNewsRequest()
        }){
            Text("Авторизоваться")
        }
    }
}