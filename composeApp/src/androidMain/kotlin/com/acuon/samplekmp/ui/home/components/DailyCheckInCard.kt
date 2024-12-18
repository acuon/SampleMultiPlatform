package com.acuon.samplekmp.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.home.models.CheckInDto
import com.acuon.samplekmp.ui.navigation.Screen

@Composable
fun DailyCheckInCard(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val checkInItems = remember {
        mutableListOf(
            CheckInDto("Meals", false, R.drawable.ic_meals),
            CheckInDto("Mood", true, R.drawable.ic_meals),
            CheckInDto("Activity", false, R.drawable.ic_meals),
            CheckInDto("Weight", false, R.drawable.ic_meals),
            CheckInDto("Note", false, R.drawable.ic_meals)
        )
    }

    Column(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "My daily check-in", style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = "more", style = MaterialTheme.typography.titleMedium
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                Icons.Default.KeyboardArrowLeft,
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.White)
            )
            Text(
                text = "Wed, 22 Apr 2022", style = MaterialTheme.typography.titleMedium
            )
            Image(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Profile picture",
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(Color.White)
            )
        }
        Spacer(Modifier.height(8.dp))
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            checkInItems.forEach { item ->
                val isCompleted = remember { mutableStateOf(item.isCompleted) }
                DailyCheckInItem(
                    label = item.label, isCompleted = isCompleted.value, checkInIcon = item.icon
                ) {
//                    isCompleted.value = !isCompleted.value
//                    item.isCompleted = isCompleted.value
                    navController.navigate(Screen.Meal.route)
                }
            }
        }
    }
}

