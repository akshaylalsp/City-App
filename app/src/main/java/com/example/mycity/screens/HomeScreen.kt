package com.example.mycity.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import com.example.mycity.data.places


@Composable
fun HomeScreen(navController: NavHostController){
    NavHost(navController = navController, startDestination = "category"){
        composable("category") {
            CategoryScreen(places)
        }
        composable("recommendation") {
            RecommendationScreen(places)
        }
        composable("detail") {
            DetailedCard()
        }

    }
}