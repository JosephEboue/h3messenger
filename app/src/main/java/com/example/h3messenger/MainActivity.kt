package com.example.h3messenger

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.h3messenger.ui.theme.H3messengerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            H3messengerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigator()
                }
            }
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier = Modifier, onSubmit:()->Unit) {
    val username = remember { mutableStateOf("") }
    //val password = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)){
        // Greeting text
        Text(text = "Login", modifier = modifier.padding(bottom = 8.dp))

        //Input Field
        OutlinedTextField(
            value = username.value,
            onValueChange = {username.value = it},
            label = { Text("Enter your name")}
        )
       /* OutlinedTextField(
            value = password.value,
            onValueChange = {password.value = it},
            label = { Text("Password")}
        )
        */
        Button(onClick = { onSubmit() }, modifier = modifier.padding(8.dp)) {
            Text(text = "Login")
        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(name: String, modifier: Modifier = Modifier, onSubmit:()->Unit) {
    val text = remember { mutableStateOf("") }
    //val password = remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(16.dp)){
        // Greeting text
        Text(text = "Welcome $name to H3 Messenger", modifier = modifier.padding(bottom = 8.dp))
    }
    Button(onClick = { onSubmit() }, modifier = modifier.padding(8.dp)) {
        Text(text = "Back to login")
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    H3messengerTheme {
        Navigator()
    }
}
@Composable
fun Navigator(){
    val currentPage = remember { mutableStateOf("login") }
    when(currentPage.value){
        "login" -> LoginPage(){currentPage.value="home"}
        "home" -> HomePage(""){currentPage.value="login"}
    }
}