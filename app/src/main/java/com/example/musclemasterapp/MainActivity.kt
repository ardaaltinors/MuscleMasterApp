package com.example.musclemasterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.musclemasterapp.api.MealPlanScreen
import com.example.musclemasterapp.auth.LoginScreen
import com.example.musclemasterapp.auth.ProfileScreen
import com.example.musclemasterapp.auth.SignupScreen
import com.example.musclemasterapp.main.CalculatorsScreen
import com.example.musclemasterapp.main.ExerciseScreen
import com.example.musclemasterapp.main.NotificationMessage
import com.example.musclemasterapp.main.WorkoutsScreen
import com.example.musclemasterapp.ui.theme.MuscleMasterAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MuscleMasterAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MuscleApp()
                }
            }
        }
    }
}

sealed class DestinationScreen(val route: String) {
    object Signup: DestinationScreen("signup")
    object Login: DestinationScreen("login")
    object Workouts: DestinationScreen("workouts")
    object Calculators: DestinationScreen("calculators")
    object Profile: DestinationScreen("profile")
    object Exercises: DestinationScreen("exercises/{muscleGroup}")
    object MealPlan: DestinationScreen("mealplan/{targetCalories}")
}

@Composable
fun MuscleApp() {
    val vm = hiltViewModel<AppViewModel>()
    val navController = rememberNavController()

    NotificationMessage(vm = vm)

    NavHost(navController = navController, startDestination = DestinationScreen.Signup.route) {
        composable(DestinationScreen.Signup.route) {
            SignupScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Login.route) {
            LoginScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Workouts.route) {
            WorkoutsScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Profile.route) {
            ProfileScreen(navController = navController, vm = vm)
        }
        composable(DestinationScreen.Calculators.route) {
            CalculatorsScreen(navController = navController, vm = vm)
        }
        composable(route = DestinationScreen.Exercises.route,
            arguments = listOf(navArgument("muscleGroup") { type = NavType.StringType })
        ) { backStackEntry ->
            ExerciseScreen(navController = navController, vm = vm,
                muscleGroup = backStackEntry.arguments?.getString("muscleGroup") ?: "")
        }
        composable(route = DestinationScreen.MealPlan.route,
            arguments = listOf(navArgument("targetCalories") { type = NavType.StringType })
        ) { backStackEntry ->
            MealPlanScreen(navController = navController,
                targetCalories = backStackEntry.arguments?.getString("targetCalories") ?: "")
        }
    }

}