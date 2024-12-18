package com.acuon.samplekmp.ui.meal.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.meal.components.CompositionUI
import com.acuon.samplekmp.ui.home.components.RewardPointsUI
import com.acuon.samplekmp.ui.meal.components.NutrientsUI
import com.acuon.samplekmp.ui.meal.components.PortionUI
import com.acuon.samplekmp.ui.meal.components.RatingsUI
import com.acuon.samplekmp.ui.utils.DataUtils

@Composable
fun MealScreen(navController: NavHostController = rememberNavController()) {
    var weight by remember { mutableIntStateOf(0) }
    var ratings by remember { mutableIntStateOf(0) }
    val nutrientList = remember { DataUtils.nutrientList }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F8F8))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(bottom = 72.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF6A1B6A))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
                    Text("Meal", color = Color.White, fontSize = 18.sp)
                    Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Color.White)
                }
            }

            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = "Raspberry cheesecake",
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(top = 8.dp)
                        )
                        RewardPointsUI("2", modifier = Modifier.padding(top = 4.dp))
                    }
                    Image(
                        painter = painterResource(R.drawable.ic_favorite),
                        contentDescription = "favorite",
                        modifier = Modifier
                            .background(Color(0xFFEBEFF8), RoundedCornerShape(100.dp))
                            .padding(8.dp),
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.image_raspberry),
                    contentDescription = "Raspberry Cheesecake",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(500.dp)
                        .padding(top = 8.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
            }

            PortionUI {
                weight = it
            }

            NutrientsUI(nutrientList)

            CompositionUI(
                title = "Composition",
                proteins = 20f,
                carbs = 50f,
                fats = 30f,
                total = 100f
            )

            RatingsUI {
                ratings = it
            }
        }

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    if (weight > 0 && ratings > 0) Color(0xFFFFC107)
                    else Color.LightGray
                ),
            colors = ButtonDefaults.buttonColors(
                containerColor = if (weight > 0 && ratings > 0) Color(0xFFFFC107)
                else Color.LightGray
            )
        ) {
            Text("Save", color = Color.Black, fontSize = 16.sp)
        }
    }
}

