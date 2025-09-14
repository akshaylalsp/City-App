package com.example.mycity.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import com.example.mycity.data.PlaceDetailData

@Composable
fun ListCardItem(title: String,modifier: Modifier){
    Card(modifier) {
        Text(text = title, fontStyle = FontStyle.Normal)
    }
}

@Composable
fun DetailedCard(place: PlaceDetailData,onBack:()->Unit){
    BackHandler {
        onBack()
    }
    Column {
        val image = painterResource(place.image)
        Image(
            image,
            contentDescription = "",
            modifier = Modifier,
            contentScale = ContentScale.Crop
        )
        Text(place.description)
    }
}