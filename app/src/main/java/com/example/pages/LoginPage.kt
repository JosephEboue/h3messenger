package com.example.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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
            label = { Text("Enter your name") }
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