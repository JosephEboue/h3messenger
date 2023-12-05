package com.example.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.utils.formatDate
import java.util.Date

//@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomePage(modifier: Modifier = Modifier, onBackPressed:()->Unit, onDiscClicked:(String)->Unit) {
    val text = remember { mutableStateOf("") }
    //val password = remember { mutableStateOf("") }
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        makeConversation.forEach { conversation ->
            Row (modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onDiscClicked(conversation.name) }) {
                Column {
                    Image(
                        painter = painterResource(R.drawable.him),
                        contentDescription = "coucou",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape)
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)) {
                    Text("${conversation.name}")
                    Text("${conversation.lastMessage}")
                    Text("${conversation.dateTime}")
                    //Spacer(modifier = Modifier.padding(5.dp))
                    //Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
        Button(onClick = { onBackPressed() }, modifier = modifier.padding(8.dp)) {
            Text(text = "Back to login")
        }
    }
}