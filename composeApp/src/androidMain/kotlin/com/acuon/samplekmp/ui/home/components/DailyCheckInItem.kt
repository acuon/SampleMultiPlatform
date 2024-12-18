package com.acuon.samplekmp.ui.home.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DailyCheckInItem(
    label: String, isCompleted: Boolean, checkInIcon: Int, checkInCallback: (Boolean) -> Unit
) {
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 2.dp), colors = CardColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        disabledContentColor = Color.Transparent,
        disabledContainerColor = Color.Transparent
    ), onClick = {
        checkInCallback.invoke(!isCompleted)
    }) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp, horizontal = 16.dp)
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(checkInIcon),
                    contentDescription = "Completed",
                    tint = if (isCompleted) Color.Green else Color.Black
                )
                Spacer(Modifier.width(4.dp))
                Text(label, fontSize = 18.sp)
            }

            CustomCheckbox(isCompleted) {
                checkInCallback.invoke(!isCompleted)
            }
        }
    }
}

@Composable
fun CustomCheckbox(
    isChecked: Boolean, onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clickable { onCheckedChange(!isChecked) },
        contentAlignment = Alignment.Center
    ) {
        if (isChecked) {
            Canvas(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(100.dp))
            ) {
                drawCircle(color = Color.Green)
            }
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "Checked",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )
        } else {
            Canvas(
                modifier = Modifier
                    .size(24.dp)
                    .clip(RoundedCornerShape(100.dp))
            ) {
                drawCircle(color = Color.Green, style = Stroke(width = 3.dp.toPx()))
            }
        }
    }
}
