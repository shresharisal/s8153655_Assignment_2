package com.example.s8153655_assignment2.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.s8153655_assignment2.data.model.Entity



@Composable
fun AppNavigation(navController: NavHostController) {
    _root_ide_package_.androidx.navigation.NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            LoginScreen(
                onLoginSuccess = { keypass ->
                    navController.navigate(Screen.Dashboard.createRoute(keypass))
                }
            )
        }

        composable(
            route = Screen.Dashboard.route,
            arguments = Screen.Dashboard.arguments
        ) { backStackEntry ->
            val keypass = backStackEntry.arguments?.getString("keypass") ?: ""
            DashboardScreen(
                keypass = keypass,
                onEntityClick = { entity ->
                    // Store entity in a shared way - for simplicity, we'll pass basic info
                    navController.navigate(Screen.Details.createRoute(entity))
                }
            )
        }

        composable(
            route = Screen.Details.route,
            arguments = Screen.Details.arguments
        ) { backStackEntry ->
            val property1 = backStackEntry.arguments?.getString("property1") ?: ""
            val property2 = backStackEntry.arguments?.getString("property2") ?: ""
            val description = backStackEntry.arguments?.getString("description") ?: ""

            val entity = Entity(
                property1 = property1,
                property2 = property2,
                description = description
            )

            DetailsScreen(
                entity = entity,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Dashboard : Screen("dashboard/{keypass}") {
        val arguments = listOf(
            androidx.navigation.navArgument("keypass") { type = androidx.navigation.NavType.StringType }
        )
        fun createRoute(keypass: String) = "dashboard/$keypass"
    }
    object Details : Screen("details/{property1}/{property2}/{description}") {
        val arguments = listOf(
            androidx.navigation.navArgument("property1") { type = androidx.navigation.NavType.StringType },
            androidx.navigation.navArgument("property2") { type = androidx.navigation.NavType.StringType },
            androidx.navigation.navArgument("description") { type = androidx.navigation.NavType.StringType }
        )
        fun createRoute(entity: Entity) = "details/${entity.property1}/${entity.property2}/${entity.description}"
    }
}
