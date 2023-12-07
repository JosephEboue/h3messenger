package com.example.pages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pages.viewModels.LoginViewModel

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(modifier: Modifier = Modifier,
              viewModel: LoginViewModel = LoginViewModel(),
              onSubmit:()->Unit
            ) {

    val username = remember { mutableStateOf("") }
    val errorMessage = remember { mutableStateOf("") }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        // Greeting text
        Text(text = "Login", modifier = modifier.padding(bottom = 8.dp))

        //Input Field
        OutlinedTextField(
            value = username.value,
            onValueChange = {username.value = it},
            label = { Text("Enter your name") }
        )

        // Display error message if username is empty
        if (errorMessage.value.isNotBlank()) {
            Text(text = errorMessage.value, color = Color.Red)
        }
        Button(onClick = {
            if (username.value.isNotBlank()) {
                viewModel.saveUsername(username.value)
                onSubmit()
            } else {
                errorMessage.value = "Please enter a username"
            }
        },
            modifier = modifier.padding(8.dp)) {
            Text(text = "Login")
            }
    }
}