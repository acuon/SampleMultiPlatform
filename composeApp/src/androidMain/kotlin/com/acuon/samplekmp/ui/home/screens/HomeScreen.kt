package com.acuon.samplekmp.ui.home.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.home.components.DailyCheckInCard
import com.acuon.samplekmp.ui.home.components.DailyCheckInItem
import com.acuon.samplekmp.ui.home.components.TasksSection
import com.acuon.samplekmp.ui.home.components.UserGreeting
import com.acuon.samplekmp.ui.home.models.CheckInDto
import com.acuon.samplekmp.ui.home.models.TaskModel
import com.acuon.samplekmp.ui.navigation.Screen
import com.acuon.samplekmp.ui.utils.DataUtils
import com.acuon.samplekmp.ui.utils.calculateProgress
import com.acuon.samplekmp.ui.utils.toPercentage

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

@Composable
fun RewardPointsUI(points: String, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = modifier) {
        Text(
            points,
            fontSize = 13.sp,
            modifier = Modifier.padding(end = 3.dp)
        )
        Icon(
            painter = painterResource(R.drawable.ic_diamond),
            contentDescription = "Diamond",
            tint = Color(0xFFDA5C01)
        )
    }
}

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
                    com.acuon.samplekmp.ui.home.components.CircularProgressBarWithText(
                        modifier = Modifier.padding(end = 12.dp),
                        progress = task.progress ?: 0f,
                        task.progress.toString()
                    )
                } else if (task.showTaskProgress == true) {
                    com.acuon.samplekmp.ui.home.components.CircularTaskProgress(
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
                        com.acuon.samplekmp.ui.home.components.RewardPointsUI(task.taskPoints.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun UserGreeting(modifier: Modifier = Modifier) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
            .background(Color.White),
        colors = CardColors(
            containerColor = Color.White,
            contentColor = Color.Black,
            disabledContentColor = Color.Transparent,
            disabledContainerColor = Color.Transparent
        )
    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth(),
        ) {
            Text(
                modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp),
                text = "Good morning, Jeanette!",
                color = Color.Black,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
            )
            Row(
                modifier = Modifier.padding(
                    top = 8.dp, start = 16.dp, end = 16.dp, bottom = 16.dp
                )
            ) {
                Image(
                    painter = painterResource(R.drawable.ic_default_avatar),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .size(64.dp)
                        .clip(RoundedCornerShape(8.dp))
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Great that you're here, you have 5 new tasks.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
            }
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