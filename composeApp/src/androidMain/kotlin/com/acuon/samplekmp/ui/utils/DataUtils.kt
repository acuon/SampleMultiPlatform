package com.acuon.samplekmp.ui.utils

import androidx.compose.ui.graphics.Color
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.meal.model.NutrientBreakDown
import com.acuon.samplekmp.ui.meal.model.NutrientModel
import com.acuon.samplekmp.ui.home.models.TaskModel

object DataUtils {
    val tasksList = mutableListOf(
        TaskModel(
            title = "Physical Activity",
            description = "I would like to run in the morning before work.",
            progress = 0f,
            isCompleted = false,
            sideColor = Color(0xFF2C83E9),
            showTaskProgress = true,
            completedTasks = 1,
            totalTasks = 4,
            taskPoints = 2
        ),
        TaskModel(
            title = "Meal rhythm",
            progress = 0.25f,
            isCompleted = false,
            sideColor = Color(0xFF63004E),
            showCircularProgress = true,
            totalTasks = 3
        ),
        TaskModel(
            title = "Longer survey title",
            progress = 0f,
            isCompleted = true,
            sideColor = Color(0xFFFFB100),
            taskPoints = 2,
            taskType = "Survey",
            endDate = "Sep 23"
        ),
        TaskModel(
            title = "Longer survey title",
            description = "Survey • Sep 30",
            progress = 0f,
            isCompleted = false,
            sideColor = Color(0xFFFFB100),
            taskPoints = 2,
            taskType = "Survey",
            endDate = "Sep 30"
        )
    )
    val nutrientList = listOf(
        NutrientModel(
            label = "Carbohydrate",
            icon = R.drawable.meal_icon_carb,
            quantityInPercentage = 50,
            quantityInGm = 12,
            nutrientBreakDown = listOf(
                NutrientBreakDown(
                    "Sugars",
                    quantityInPercentage = 10,
                    quantityInGm = 2
                ),
                NutrientBreakDown(
                    "Fiber",
                    quantityInPercentage = 5,
                    quantityInGm = 2
                ),
                NutrientBreakDown(
                    "Starch",
                    quantityInPercentage = 35,
                    quantityInGm = 8
                )
            )
        ),
        NutrientModel(
            label = "Fat",
            icon = R.drawable.meal_icon_fat,
            quantityInPercentage = 30,
            quantityInGm = 12,
            nutrientBreakDown = listOf(
                NutrientBreakDown(
                    "Saturated Fat",
                    quantityInPercentage = 5,
                    quantityInGm = 2,
                ),
                NutrientBreakDown(
                    "Unsaturated Fat",
                    quantityInPercentage = 25,
                    quantityInGm = 10,
                )
            )
        ),
        NutrientModel(
            label = "Protein",
            icon = R.drawable.meal_icon_protien,
            quantityInPercentage = 5,
            quantityInGm = 12
        ),
        NutrientModel(
            label = "Total energy",
            icon = R.drawable.meal_icon_energy,
            quantityInKcal = 300
        )
    )
}