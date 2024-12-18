package com.acuon.samplekmp.ui.meal.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompositionUI(
    title: String? = null,
    proteins: Float,
    carbs: Float,
    fats: Float,
    total: Float
) {
    val proteinColor = Color(0xFF63004E)
    val carbColor = Color(0xFFFFB100)
    val fatColor = Color(0xFFDA5C01)

    Column(
        modifier = Modifier
            .background(Color(0xFFF8F8F8))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            title.toString(),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.padding(16.dp)
                ) {
                    Canvas(modifier = Modifier.size(200.dp)) {
                        val proteinSweepAngle = (proteins / total) * 360
                        drawArc(
                            color = proteinColor,
                            startAngle = -90f,
                            sweepAngle = proteinSweepAngle,
                            useCenter = false,
                            style = Stroke(width = 40f, cap = StrokeCap.Round)
                        )

                        val carbSweepAngle = (carbs / total) * 360
                        drawArc(
                            color = carbColor,
                            startAngle = -90f + proteinSweepAngle,
                            sweepAngle = carbSweepAngle,
                            useCenter = false,
                            style = Stroke(width = 40f, cap = StrokeCap.Round)
                        )

                        val fatSweepAngle = (fats / total) * 360
                        drawArc(
                            color = fatColor,
                            startAngle = -90f + proteinSweepAngle + carbSweepAngle,
                            sweepAngle = fatSweepAngle,
                            useCenter = false,
                            style = Stroke(width = 40f, cap = StrokeCap.Round)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Legend(color = proteinColor, label = "$proteins% Protein")
                    Legend(color = fatColor, label = "$fats% Fat")
                    Legend(color = carbColor, label = "$carbs% Carb")
                }
            }
        }
    }
}

@Composable
fun Legend(color: Color, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)
    ) {
        Box(
            modifier = Modifier
                .size(16.dp)
                .background(color = color, shape = CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = label, fontSize = 14.sp, color = Color.Black)
    }
}