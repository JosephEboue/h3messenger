package com.example.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.h3messenger.R
import com.example.h3messenger.ui.theme.H3messengerTheme
import com.example.pages.viewModels.HomeViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier,
             onBackPressed:()->Unit,
             viewModel: HomeViewModel = HomeViewModel(),
             onDiscClicked:(user: String)->Unit
            ) {
    val state by viewModel.uiState.collectAsState()
    Column (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        state.conversations.map { conversation ->
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
                }
            }
        }
        Button(onClick = { onBackPressed() }, modifier = modifier.padding(8.dp)) {
            Text(text = "Back to login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview(){
    H3messengerTheme {
        HomePage(
            onBackPressed = {},
            onDiscClicked = {}
        )
    }
}