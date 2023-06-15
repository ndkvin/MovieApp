package com.android.newsapp

import android.annotation.SuppressLint
import androidx.navigation.compose.NavHost
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import com.android.newsapp.ui.theme.LightGrey
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.newsapp.ui.navigation.Screen
import com.android.newsapp.ui.screen.home.HomeScreen
import com.android.newsapp.ui.screen.detail.DetailScreen
import com.android.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 24.dp, end = 24.dp)
                        .background(color = LightGrey)
                ) {
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.HomeScreen.route
                    ) {
                        composable(route = Screen.HomeScreen.route) {
                            HomeScreen(navController = navController)
                        }

                        composable(route = Screen.DetailScreen.route + "/{id}") { backStackEntry ->
                            val id = backStackEntry.arguments?.getString("id")
                            DetailScreen(navController = navController, id = id!!)
                        }
                    }
                }
            }
        }
    }
}
