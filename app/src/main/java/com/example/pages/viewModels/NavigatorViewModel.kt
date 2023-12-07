package com.example.pages.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class NavigationState(val currentPage: String, val currentUser: String)

class NavigatorViewModel : ViewModel() {
    private val _navigationState = MutableStateFlow(NavigationState(currentPage = "login", currentUser = ""))
    val navigationState: StateFlow<NavigationState> = _navigationState.asStateFlow()
    fun navigateTo(page: String, user: String = "") {
            _navigationState.value = NavigationState(currentPage = page, currentUser = user)

    }
}
