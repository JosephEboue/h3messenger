package com.example.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.h3messenger.R
import com.example.models.makeConversation

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier, onSubmit:()->Unit) {
    val text = remember { mutableStateOf("") }
    //val password = remember { mutableStateOf("") }
    Row (modifier = Modifier.padding(all = 8.dp)){
        Image(
            painter = painterResource(R.drawable.him),
            contentDescription = "coucou",
            modifier = Modifier.size(50.dp).clip(CircleShape)
        )
        //Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.padding(8.dp)){
            // Greeting text
            //Text(text = "H3 MESSENGER", modifier = modifier.padding(bottom = 8.dp))
            makeConversation.map {
                Text(it.name)
                Text(it.lastMessage)
                Text(it.dateTime.toString())
                Spacer(modifier = Modifier.padding(5.dp))
                Spacer(modifier = Modifier.height(2.dp))
            }
            Button(onClick = { onSubmit() }, modifier = modifier.padding(8.dp)) {
                Text(text = "Back to login")
            }
        }
    }
}