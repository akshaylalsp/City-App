package com.example.mycity.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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


@Composable
fun StylishCard(title:String,modifier: Modifier,onClickAction:()-> Unit){
    Card(modifier = modifier.fillMaxWidth().height(60.dp), onClick = onClickAction, shape = RoundedCornerShape(20), colors = CardDefaults.cardColors(
        containerColor = Color(0xFF7F24F4),   // background color of card
        contentColor = Color.White            // color of content inside the card
    ) ) {
        Box(modifier.fillMaxSize(), contentAlignment = Alignment.CenterStart){

            Text(title,modifier= Modifier.padding(start = 20.dp), fontSize = 20.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SylishCardPrev(){
    StylishCard("Alappuzha", modifier = Modifier, onClickAction = {})
}