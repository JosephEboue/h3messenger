package com.example.pages.viewModels

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.models.Conversation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class LoginViewModel (): ViewModel() {
    fun saveUsername(username: String) {
            val userId = FirebaseAuth.getInstance().currentUser?.uid
            userId?.let {
                val database = FirebaseDatabase.getInstance()
                val userRef = database.getReference("users")
                userRef.child(it).setValue(username)
            }
        }
    }


