package com.example.pages.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.models.Conversation
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel (): ViewModel() {
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()
    init {
        viewModelScope.launch {
            val database = FirebaseDatabase.getInstance()
            val userRef = database.getReference("users")
            val onSuccess = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot){
                    val users = dataSnapshot.children.toList().mapNotNull {
                        it.value as String
                    }
                    val convs = users.map {
                        Conversation(name = it, "2023-12-13", true, "Hello, comment tu vas ?")
                    }
                    _uiState.update {
                        it.copy(conversations = convs)
                    }
                }
                override fun onCancelled(databaseError: DatabaseError) {
                    print("Error fetching data: ${databaseError.message}")
                }
            }
            userRef.addValueEventListener(onSuccess)
        }
    }
}
data class HomeState(val conversations: List<Conversation> = listOf())