package com.example.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun Navigator(){
    val currentPage = remember { mutableStateOf("login") }
    val currentUser = remember { mutableStateOf("home") }
    when(currentPage.value){
        "login" -> LoginPage(){currentPage.value="home"}
        "home" -> HomePage(
            onBackPressed = {currentPage.value="login"},
            onDiscClicked = {user ->
                currentPage.value="Discussion"
                currentUser.value = user
            }
        )
        "Discussion" -> Discussion(currentUser.value){currentPage.value="home"}
    }
}