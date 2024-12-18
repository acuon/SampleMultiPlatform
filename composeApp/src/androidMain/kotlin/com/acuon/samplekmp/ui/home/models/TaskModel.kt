package com.acuon.samplekmp.ui.home.models

import androidx.compose.ui.graphics.Color

data class TaskModel(
    val title: String? = null,
    val description: String? = null,
    val progress: Float? = null,
    val isCompleted: Boolean? = null,
    val sideColor: Color? = null,
    val showCircularProgress: Boolean? = null,
    val showTaskProgress: Boolean? = null,
    val completedTasks: Int? = null,
    val totalTasks: Int? = null,
    val taskPoints: Int? = null,
    val taskType: String? = null,
    val endDate: String? = null
)
