package com.example.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

@Composable
fun Navigator(){
    val currentPage = remember { mutableStateOf("login") }
    when(currentPage.value){
        "login" -> LoginPage(){currentPage.value="home"}
        "home" -> HomePage(){currentPage.value="login"}
    }
}