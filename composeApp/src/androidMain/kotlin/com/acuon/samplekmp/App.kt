package com.acuon.samplekmp

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.acuon.samplekmp.ui.home.screens.MainScreen
import com.acuon.samplekmp.ui.meal.screens.MealScreen
import com.acuon.samplekmp.ui.navigation.Screen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun App() {
    val navController = rememberNavController()
    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = Screen.Main.route,
        ) {
            composable(Screen.Main.route) {
                MainScreen(navController = navController)
            }
            composable(Screen.Meal.route) {
                MealScreen(navController = navController)
            }
        }
    }
}
