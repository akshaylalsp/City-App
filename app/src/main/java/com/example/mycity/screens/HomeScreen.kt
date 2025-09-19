package com.example.mycity.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.mycity.data.UiState

import com.example.mycity.data.places

enum class Screens{
    CATEGORY,DETAIL,RECOMMENDATION
}


@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun myTopBar(title: String){
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            Text("+")
        }

    )
}

@SuppressLint("RestrictedApi")
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val viewModel: CityViewModel = viewModel()
    val currentStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = currentStackEntry?.destination?.route
    val uiState = viewModel.uiState.collectAsState().value
    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = { myTopBar(if(currentScreen.toString() != "DETAIL") currentScreen.toString() else uiState.selectedPlace!!.location.uppercase()) }


    ) { innerPadding ->
        val viewModel: CityViewModel = viewModel()
        NavHost(navController = navController, startDestination = "category",modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            composable(Screens.CATEGORY.name) {
                CategoryScreen(places, onClick = {
                    navController.navigate(Screens.RECOMMENDATION.name)
                })
            }
            composable(Screens.RECOMMENDATION.name) {
                RecommendationScreen(places,
                    onClick = {
                        viewModel.updateState(it)
                        navController.navigate(Screens.DETAIL.name)
                    })

            }
            composable(Screens.DETAIL.name) {
                DetailedCard(
                    onBack = {
                        navController.navigate(Screens.RECOMMENDATION.name)
                    },
                    place = uiState.selectedPlace!!
                )
            }

        }
    }

}