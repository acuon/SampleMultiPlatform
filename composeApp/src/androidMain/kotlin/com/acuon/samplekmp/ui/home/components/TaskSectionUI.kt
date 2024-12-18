package com.acuon.samplekmp.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.home.models.TaskModel
import com.acuon.samplekmp.ui.utils.DataUtils

@Composable
fun TasksSection() {
    val taskItems = remember {
        DataUtils.tasksList
    }
    Text(
        "My tasks",
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp),
        fontSize = 16.sp
    )
    Column(
        modifier = Modifier.padding(top = 12.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        taskItems.forEach { item ->
            TaskItem(item)
        }
    }
}

@Composable
fun TaskItem(task: TaskModel) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(task.sideColor ?: Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(start = 7.dp)
                .background(Color.Black)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (task.showCircularProgress == true) {
                    CircularProgressBarWithText(
                        modifier = Modifier.padding(end = 12.dp),
                        progress = task.progress ?: 0f,
                        task.progress.toString()
                    )
                } else if (task.showTaskProgress == true) {
                    CircularTaskProgress(
                        modifier = Modifier.padding(end = 12.dp),
                        task.completedTasks ?: 0,
                        task.totalTasks ?: 0
                    )
                }
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        task.title.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        fontSize = 18.sp
                    )
                    if (task.description != null) {
                        Text(
                            task.description.toString(),
                            style = MaterialTheme.typography.bodySmall,
                            fontSize = 13.sp
                        )
                    } else if (task.totalTasks != null) {
                        Text("${task.totalTasks} tasks")
                    } else {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(task.taskType.toString(), fontSize = 13.sp)
                            Text("•", modifier = Modifier.padding(4.dp), fontSize = 13.sp)
                            Text(task.endDate.toString(), fontSize = 13.sp)
                        }
                    }
                }
                if (task.taskPoints != null) {
                    Column(
                        modifier = Modifier.padding(start = 8.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Text("")
                        Icon(
                            painter = painterResource(R.drawable.ic_meals),
                            contentDescription = "",
                            tint = Color.White
                        )
                        RewardPointsUI(task.taskPoints.toString())
                    }
                }
            }
        }
    }
}