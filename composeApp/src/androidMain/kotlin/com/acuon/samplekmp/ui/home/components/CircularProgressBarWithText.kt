package com.acuon.samplekmp.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.acuon.samplekmp.ui.utils.toPercentage

@Composable
fun CircularProgressBarWithText(modifier: Modifier, progress: Float, text: String) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        CircularProgressIndicator(
            progress = progress,
            color = Color(0xFFFFB100),
            strokeWidth = 4.dp,
            trackColor = Color(0xFFDDE3EE)
        )

        Text(
            text = buildString {
                append(progress.toPercentage())
                append("%")
            },
            style = MaterialTheme.typography.bodySmall,
            color = Color.Black
        )
    }
}
