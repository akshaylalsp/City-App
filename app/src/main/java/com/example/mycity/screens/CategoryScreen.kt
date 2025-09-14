package com.example.mycity.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mycity.data.PlaceDetailData

@Composable
fun CategoryScreen(list: List<PlaceDetailData>, onClick: () -> Unit){
    LazyColumn {
        items(list){
            ListCardItem(
                it.category,
                modifier = Modifier.clickable(onClick={onClick()})
            )
        }
    }
}


@Composable
fun RecommendationScreen(list: List<PlaceDetailData>,onClick:(PlaceDetailData)->Unit){
    LazyColumn {
        items(list){
            ListCardItem(it.location, modifier = Modifier.clickable(onClick = {onClick(it)}))
        }
    }
}


