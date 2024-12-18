package com.acuon.samplekmp.ui.meal.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.meal.model.NutrientBreakDown
import com.acuon.samplekmp.ui.meal.model.NutrientModel


@Composable
fun NutrientsUI(nutrients: List<NutrientModel>) {
    Text(
        text = "Nutrients",
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            nutrients.forEach { item ->
                NutrientRow(item)
            }
        }
    }
}

@Composable
fun NutrientRow(nutrient: NutrientModel) {
    Column(modifier = Modifier.padding(vertical = 8.dp, horizontal = 12.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(nutrient.icon ?: 0),
                    modifier = Modifier
                        .height(36.dp)
                        .width(36.dp),
                    contentDescription = ""
                )
                Text(
                    nutrient.label,
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Row {
                if (nutrient.quantityInKcal != null) {
                    Text(
                        "${nutrient.quantityInKcal} kcal",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                } else {
                    Text(
                        "${nutrient.quantityInGm}g",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        "${nutrient.quantityInPercentage}%",
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            nutrient.nutrientBreakDown?.forEach { item ->
                NutrientBreakDownRow(item)
            }
        }
    }
}

@Composable
fun NutrientBreakDownRow(nutrient: NutrientBreakDown?) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_launcher_background),
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp),
                contentDescription = "",
                tint = Color.Transparent
            )
            Text(
                nutrient?.label.toString(),
                color = Color.Black,
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 4.dp)
            )
        }
        Row {
            if (nutrient?.quantityInKcal != null) {
                Text(
                    "${nutrient.quantityInKcal} kcal",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            } else {
                Text(
                    "${nutrient?.quantityInGm}g",
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    "${nutrient?.quantityInPercentage}%",
                    color = Color.Black
                )
            }
        }
    }
}