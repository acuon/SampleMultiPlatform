package com.acuon.samplekmp.ui.meal.components

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acuon.samplekmp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

@Composable
fun PortionUI(weightCallback: (Int) -> Unit) {
    var weight by remember { mutableIntStateOf(0) }

    Text(
        "Portion",
        modifier = Modifier.padding(top = 22.dp, start = 16.dp),
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Default.KeyboardArrowLeft,
            contentDescription = "Remove",
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFFFB100))
                .clickable {
                    if (weight > 0) weight--
                    weightCallback(weight)
                },
            tint = Color.Black
        )
        WeightInputBox(weight = weight) { newWeight ->
            weight = newWeight
            weightCallback(weight)
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = "Add",
            modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(100.dp))
                .background(Color(0xFFFFB100))
                .clickable {
                    weight++
                    weightCallback(weight)
                },
            tint = Color.Black
        )
    }

    Row(
        modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.ic_default_avatar), contentDescription = "",
        )
        Text(
            "Tip! You can give me an approximate measure or you can ask me for a suggestion.",
            modifier = Modifier.padding(start = 8.dp, end = 16.dp),
            fontSize = 13.sp
        )
    }

}

@Composable
fun WeightInputBox(weight: Int, onWeightChange: (Int) -> Unit) {
    Column(
        modifier = Modifier.background(
            color = Color.White, shape = RoundedCornerShape(
                topStart = 24.dp, topEnd = 24.dp
            )
        )
    ) {
        Text(
            text = "Weight | gm",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = Color.Black,
            fontWeight = FontWeight.Light
        )

        TextField(
            value = weight.toString(),
            onValueChange = { newValue ->
                val parsedValue = newValue.toIntOrNull() ?: 0
                onWeightChange(parsedValue)
            },
            placeholder = { Text("Enter weight") },
            modifier = Modifier.background(Color.White),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(fontSize = 16.sp)
        )
    }
}