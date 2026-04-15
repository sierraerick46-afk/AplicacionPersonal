package com.example.aplicacionperfil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.aplicacionperfil.ui.screens.DetailScreen
import com.example.aplicacionperfil.ui.screens.ProfileScreen
import com.example.aplicacionperfil.ui.theme.AplicacionPerfilTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicacionPerfilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "profile"
    ) {
        composable("profile") {
            ProfileScreen(
                onNavigateToHobbies = { hobbiesList ->
                    navController.navigate("hobbies/${hobbiesList.joinToString(",")}")
                },
                onNavigateToPasatiempos = { pasatiemposList ->
                    navController.navigate("pasatiempos/${pasatiemposList.joinToString(",")}")
                },
                onNavigateToDeportes = { deportesList ->
                    navController.navigate("deportes/${deportesList.joinToString(",")}")
                },
                onNavigateToIntereses = { interesesList ->
                    navController.navigate("intereses/${interesesList.joinToString(",")}")
                },
                onNavigateToMusica = { musicaList ->
                    navController.navigate("musica/${musicaList.joinToString(",")}")
                }
            )
        }

        composable(
            route = "hobbies/{items}",
            arguments = listOf(navArgument("items") { type = NavType.StringType })
            ) { backStackEntry ->
            val items = backStackEntry.arguments?.getString("items")?.split(",") ?: emptyList()
            DetailScreen(
                title = "🎨 Hobbies",
                items = items,
                onBackPressed = { navController.popBackStack() }
            )
        }

        composable(
            route = "pasatiempos/{items}",
            arguments = listOf(navArgument("items") { type = NavType.StringType })
            ) { backStackEntry ->
            val items = backStackEntry.arguments?.getString("items")?.split(",") ?: emptyList()
            DetailScreen(
                title = "🎮 Pasatiempos",
                items = items,
                onBackPressed = { navController.popBackStack() }
            )
        }

        composable(
            route = "deportes/{items}",
            arguments = listOf(navArgument("items") { type = NavType.StringType })
            ) { backStackEntry ->
            val items = backStackEntry.arguments?.getString("items")?.split(",") ?: emptyList()
            DetailScreen(
                title = "⚽ Deportes Favoritos",
                items = items,
                onBackPressed = { navController.popBackStack() }
            )
        }

        composable(
            route = "intereses/{items}",
            arguments = listOf(navArgument("items") { type = NavType.StringType })
        ) { backStackEntry ->
            val items = backStackEntry.arguments?.getString("items")?.split(",") ?: emptyList()
            DetailScreen(
                title = "⭐ Intereses Personales",
                items = items,
                onBackPressed = { navController.popBackStack() }
            )
        }

        composable(
            route = "musica/{items}",
            arguments = listOf(navArgument("items") { type = NavType.StringType })
            ) { backStackEntry ->
            val items = backStackEntry.arguments?.getString("items")?.split(",") ?: emptyList()
            DetailScreen(
                title = "🎵 Gustos Musicales",
                items = items,
                onBackPressed = { navController.popBackStack() }
            )
        }
    }
}