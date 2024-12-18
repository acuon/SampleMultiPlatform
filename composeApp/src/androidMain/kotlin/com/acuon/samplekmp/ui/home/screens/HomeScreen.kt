package com.acuon.samplekmp.ui.home.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.acuon.samplekmp.ui.home.components.DailyCheckInCard
import com.acuon.samplekmp.ui.home.components.TasksSection
import com.acuon.samplekmp.ui.home.components.UserGreeting

@Composable
fun HomeScreen(navController: NavHostController, modifier: Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEBEFF8))
    ) {
        item {
            UserGreeting(
                modifier = Modifier
                    .background(Color.White)
                    .clip(RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)),
            )
        }

        item {
            DailyCheckInCard(
                modifier = Modifier
                    .fillMaxWidth(),
                navController
            )
        }

        item {
            TasksSection()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowDemo() {
    MaterialTheme {
        HomeScreen(rememberNavController(), Modifier)
    }
}