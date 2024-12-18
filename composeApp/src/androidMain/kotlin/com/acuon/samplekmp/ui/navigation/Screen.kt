package com.acuon.samplekmp.ui.navigation

import com.acuon.samplekmp.R

sealed class BottomNavigationScreen(val route: String, val icon: Int, val title: String) {
    object Home : BottomNavigationScreen("home", R.drawable.ic_home, "Home")
    object Progress : BottomNavigationScreen("progress", R.drawable.ic_progress, "Progress")
    object Inspiration : BottomNavigationScreen("inspo", R.drawable.ic_inspo, "Inspo")
    object Inbox : BottomNavigationScreen("inbox", R.drawable.ic_inbox, "Inbox")
    object Info : BottomNavigationScreen("info", R.drawable.ic_info, "Info")
}

sealed class Screen(val route: String, val title: String) {
    data object Main : Screen("main", "Main")
    data object Meal : Screen("meal", "Meal")
}