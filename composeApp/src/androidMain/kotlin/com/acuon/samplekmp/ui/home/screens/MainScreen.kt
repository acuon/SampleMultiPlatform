package com.acuon.samplekmp.ui.home.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.acuon.samplekmp.R
import com.acuon.samplekmp.ui.navigation.BottomNavigationScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    var selectedScreen by remember { mutableStateOf<BottomNavigationScreen>(BottomNavigationScreen.Home) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF63004E),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White,
                    actionIconContentColor = Color.White
                ),
                title = {
                    Text(
                        text = selectedScreen.title,
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Image(
                            painter = painterResource(R.drawable.ic_notification),
                            contentDescription = "Notifications"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_settings),
                            contentDescription = "Settings"
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar(
                modifier = Modifier.background(Color(0xFFFFFFFF)),
                containerColor = Color.White,
                contentColor = Color.Gray,
                tonalElevation = 4.dp
            ) {
                val screens = listOf(
                    BottomNavigationScreen.Home,
                    BottomNavigationScreen.Progress,
                    BottomNavigationScreen.Inspiration,
                    BottomNavigationScreen.Inbox,
                    BottomNavigationScreen.Info
                )

                screens.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            Icon(
                                painter = painterResource(screen.icon),
                                contentDescription = screen.title
                            )
                        },
                        label = { Text(screen.title) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color.Black,
                            selectedTextColor = Color.Black,
                            indicatorColor = Color(0xFFF1DAC9)
                        ),
                        selected = selectedScreen == screen,
                        onClick = {
                            selectedScreen = screen
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = innerPadding.calculateTopPadding(),
                    bottom = innerPadding.calculateBottomPadding()
                )
        ) {
            if (selectedScreen.title == BottomNavigationScreen.Home.title) {
                HomeScreen(navController, modifier = Modifier.fillMaxSize())
            } else {
                Text(
                    text = "Content for ${selectedScreen.title}",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}

@Composable
@Preview
@androidx.compose.ui.tooling.preview.Preview(showBackground = true)
fun MainScreenPreview() {
    MaterialTheme {
        MainScreen(rememberNavController())
    }
}