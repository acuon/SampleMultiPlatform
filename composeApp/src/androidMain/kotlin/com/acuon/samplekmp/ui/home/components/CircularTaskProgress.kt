package com.acuon.samplekmp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.utils.calculateProgress

@Composable
fun CircularTaskProgress(
    modifier: Modifier,
    completedTasks: Int,
    totalTasks: Int
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
        ) {
            CircularProgressIndicator(
                progress = calculateProgress(completedTasks, totalTasks),
                color = Color(0xFFFFB100),
                strokeWidth = 4.dp,
                trackColor = Color(0xFFDDE3EE)
            )
            Icon(
                painter = painterResource(R.drawable.ic_task_progress),
                contentDescription = "Completed",
                tint = Color.Gray
            )
        }
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .padding(top = 4.dp)
        ) {
            Text(
                text = buildString {
                    append(completedTasks)
                    append("/")
                    append(totalTasks)
                },
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black,
                modifier = Modifier
                    .background(Color.Black)
                    .background(Color(0xFFF7F8FB))
                    .padding(vertical = 2.dp, horizontal = 4.dp)
            )
        }
    }
}
