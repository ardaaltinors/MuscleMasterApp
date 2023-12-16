package com.example.musclemasterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.musclemasterapp.auth.LoginScreen
import com.example.musclemasterapp.auth.ProfileScreen
import com.example.musclemasterapp.auth.SignupScreen
import com.example.musclemasterapp.main.CalculatorsScreen
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
    }

}