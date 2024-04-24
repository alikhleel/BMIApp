package com.alikhalil.bmiapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alikhalil.bmiapp.ui.BMIScreen
import com.alikhalil.bmiapp.ui.ResultScreen

enum class Screen {
    BMICalculator, Result
}

sealed class NavigationItem(val route: String) {
    data object BMICalculator : NavigationItem(Screen.BMICalculator.name)
    data object Result : NavigationItem(Screen.Result.name)
}

@Composable
fun NavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.BMICalculator.route,
) {
    NavHost(
        modifier = modifier, navController = navController, startDestination = startDestination
    ) {
        composable(NavigationItem.BMICalculator.route) {
            BMIScreen(navController = navController)
        }
        composable(NavigationItem.Result.route.plus("/bmi={bmi}&category={category}"),
            arguments = listOf(
                navArgument("bmi") { type = NavType.FloatType },
                navArgument("category") { type = NavType.StringType }
            )) { backStackEntry ->
            ResultScreen(
                navController = navController,
                bmi = backStackEntry.arguments?.getFloat("bmi") ?: 0f,
                bmiCategory = backStackEntry.arguments?.getString("category") ?: ""
            )
        }
    }
}

