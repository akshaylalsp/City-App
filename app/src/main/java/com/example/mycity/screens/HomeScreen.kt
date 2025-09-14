package com.example.mycity.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.mycity.data.places


@Composable
fun HomeScreen(navController: NavHostController, viewModel: CityViewModel,modifier: Modifier) {
    val uiState = viewModel.uiState.collectAsState().value
    NavHost(navController = navController, startDestination = "category",modifier = modifier.fillMaxSize()) {
        composable("category") {
            CategoryScreen(places, onClick = {
                navController.navigate("recommendation")
            })
        }
        composable("recommendation") {
            RecommendationScreen(places,
                onClick = {
                    viewModel.updateState(it)
                    navController.navigate("detail")
            })

        }
        composable("detail") {
            DetailedCard(
                onBack = {
                    navController.navigate("recommendation")
                },
                place = uiState.selectedPlace!!
            )
        }

    }
}