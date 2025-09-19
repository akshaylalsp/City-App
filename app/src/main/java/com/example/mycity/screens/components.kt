package com.example.mycity.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
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
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        val image = painterResource(place.image)
        Image(
            image,
            contentDescription = "",
            modifier = Modifier.size(300.dp).clip(RoundedCornerShape(20)),
            contentScale = ContentScale.Crop,



        )
        Text(place.description)
    }
}