package com.acuon.samplekmp.ui.meal.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun RatingsUI(ratingsCallback: (Int) -> Unit) {
    var rating by remember { mutableIntStateOf(0) }
    Text(
        text = "Please rate your hunger before you started to eat",
        modifier = Modifier.padding(16.dp),
        fontWeight = FontWeight.Medium
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(vertical = 16.dp)
            .horizontalScroll(rememberScrollState(), true),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        (1..5).forEach { number ->
            Box(
                modifier = Modifier
                    .background(
                        if (number == rating) Color(0xFFFFC107) else Color.LightGray,
                        RoundedCornerShape(8.dp)
                    )
                    .clickable {
                        rating = number
                        ratingsCallback(rating)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    number.toString(),
                    color = Color.White,
                    modifier = Modifier
                        .padding(vertical = 24.dp, horizontal = 16.dp)
                        .background(Color.Red, CircleShape)
                        .size(20.dp)
                        .align(Alignment.Center),
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}