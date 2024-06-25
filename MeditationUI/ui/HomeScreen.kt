package com.example.composepractice.NewPractice.MeditationUI.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.NewPractice.MeditationUI.Feature
import com.example.composepractice.NewPractice.MeditationUI.standardQuadTo
import com.example.composepractice.NewPractice.MeditationUI.ui.theme.ButtonBlue
import com.example.composepractice.NewPractice.MeditationUI.ui.theme.DarkerButtonBlue
import com.example.composepractice.NewPractice.MeditationUI.ui.theme.DeepBlue
import com.example.composepractice.NewPractice.MeditationUI.ui.theme.LightRed
import com.example.composepractice.NewPractice.MeditationUI.ui.theme.TextWhite
import com.example.composepractice.R

@Composable
fun HomeScreen(){
    Box(modifier = Modifier
        .background(DeepBlue)
        .fillMaxSize()
    ){
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep","Insormia","Depression"))
            CurrentMeditation()
        }
    }
}

@Composable
fun GreetingSection(
    name : String = "Devansh"
){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(text = "Good morning, $name",
                style = MaterialTheme.typography.headlineMedium
                )
            Text(text = " We wish you have a good day ",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Icon(painter = painterResource(id = R.drawable.ic_search), contentDescription = "Search",
            tint = Color.White,      // for image colour,
            modifier = Modifier.size(24.dp)
            )
    }
}

@Composable
fun ChipSection(
    chips : List<String>
){
    var selectedChipIndex by remember { mutableStateOf(0) }
    LazyRow {
        items(chips.size){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 15.dp, top = 15.dp, bottom = 15.dp)
                    .clickable { selectedChipIndex = it }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) {
                            ButtonBlue
                        } else {
                            DarkerButtonBlue
                        }
                    )
                    .padding(15.dp)
            ){
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}

@Composable
fun CurrentMeditation(
    color : Color = LightRed
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(text = "Daily Thought",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(text = "Meditation . 3-10 min",
                style = MaterialTheme.typography.bodyMedium,
                color = TextWhite
            )
        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonBlue)
                .padding(10.dp)
        ){
            Icon(painter = painterResource(id = R.drawable.ic_play), contentDescription = "play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
                )
        }
    }
}

@Composable
fun FeatureSection(
    features : List<Feature>
){
    Column( modifier = Modifier.fillMaxWidth() ) {
        Text(text = "Features",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(15.dp)
            )
        LazyVerticalGrid(columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(start = 7.5.dp,end = 7.5.dp,bottom = 100.dp), // for whole box
            modifier = Modifier.fillMaxHeight()
            ) {
            items(features.size){
                    FeatureItem(features[it])
            }
        }
    }
}

@Composable
fun FeatureItem(
    feature: Feature
){
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(feature.darkColor)
    ) {
        val width = constraints.maxWidth
        val height = constraints.maxHeight
        // medium coloured path
        val mediumColuredPoint1 = Offset(0f,height*0.3f)
        val mediumColuredPoint2 = Offset(width*0.1f,height*0.35f)
        val mediumColuredPoint3 = Offset(width*0.4f,height*0.05f)
        val mediumColuredPoint4 = Offset(width*0.75f,height*0.7f)
        val mediumColuredPoint5 = Offset(width*1.4f,-height.toFloat())

        val mediumColouredPath = Path().apply {
            moveTo(mediumColuredPoint1.x,mediumColuredPoint1.y)
           standardQuadTo(mediumColuredPoint1,mediumColuredPoint2)
           standardQuadTo(mediumColuredPoint2,mediumColuredPoint3)
           standardQuadTo(mediumColuredPoint3,mediumColuredPoint4)
           standardQuadTo(mediumColuredPoint4,mediumColuredPoint5)
            lineTo(width.toFloat()+100f,height.toFloat()+100f)
            lineTo(-100f,height.toFloat()+100f)
            close()
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(mediumColouredPath,color = feature.mediumColor)
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)){
            Text(
                text = feature.title,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 26.sp,
                modifier = Modifier.align(Alignment.TopStart)
            )
            Icon(painter = painterResource(id = feature.iconId), contentDescription = "",
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
                )
            Text(text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier= Modifier
                    .clickable { }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonBlue)
                    .padding(vertical = 60.dp, horizontal = 50.dp)
                )
        }
    }
}

