package com.example.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pages.viewModels.HomeViewModel
import com.example.pages.viewModels.LoginViewModel
import com.example.pages.viewModels.NavigatorViewModel

@Composable
fun Navigator() {
    val viewModel: NavigatorViewModel = viewModel()
    val navigationState by viewModel.navigationState.collectAsState()

    when (navigationState.currentPage) {
        "login" -> LoginPage(
            viewModel = LoginViewModel()
        ) {
            viewModel.navigateTo("home")
        }
        "home" -> HomePage(
            onBackPressed = { viewModel.navigateTo("login") },
            viewModel = HomeViewModel(),
            onDiscClicked = { user ->
                viewModel.navigateTo("Discussion", user)
            }
        )
        "Discussion" -> Discussion(navigationState.currentUser) {
            viewModel.navigateTo("home")
        }
    }
}
