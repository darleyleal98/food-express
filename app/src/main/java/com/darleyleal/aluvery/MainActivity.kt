package com.darleyleal.aluvery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.darleyleal.aluvery.sampledata.sampleSections
import com.darleyleal.aluvery.ui.components.ListAllProducts
import com.darleyleal.aluvery.ui.components.SearchTextField
import com.darleyleal.aluvery.ui.screens.HomeScreen
import com.darleyleal.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "main") {
                    composable(route = "main") {
                        Surface {
                            App(navController)
                        }
                    }
                    composable(route = "listAllProducts") {
                        ListAllProducts()
                    }
                    composable(route = "searchTextField") {
                        SearchTextField()
                    }
                }
            }
        }
    }
}

@Composable
fun App(navController: NavController) {
    Surface {
        Box() {
            HomeScreen(sections = sampleSections, navController)
        }
    }
}