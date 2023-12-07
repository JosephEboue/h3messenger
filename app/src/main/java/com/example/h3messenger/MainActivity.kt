package com.example.h3messenger

import android.os.Bundle
import android.provider.Telephony.Sms.Conversations
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.OptIn
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.h3messenger.ui.theme.H3messengerTheme
import com.example.pages.HomePage
import com.example.pages.LoginPage
import com.example.pages.Navigator
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import java.time.chrono.ChronoLocalDateTime
import java.util.Date
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours

class MainActivity : ComponentActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var authStateListener: AuthStateListener
    override fun onStart() {
        super.onStart()
        auth.addAuthStateListener { authStateListener }
        auth.signInAnonymously()
            .addOnCompleteListener (this) { task ->
                if (!task.isSuccessful){
                    Toast.makeText(
                        baseContext,
                        "Authentification failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
    }
    override fun onStop() {
        super.onStop()
        auth.removeAuthStateListener { authStateListener }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        auth = FirebaseAuth.getInstance()
        // Initialize Firebase
        //FirebaseApp.initializeApp(this)
        authStateListener = AuthStateListener { firebaseAuth ->
            val user = firebaseAuth.currentUser
        }
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
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    H3messengerTheme {
        Navigator()
    }
}