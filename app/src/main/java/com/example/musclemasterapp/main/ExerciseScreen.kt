package com.example.musclemasterapp.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.musclemasterapp.AppViewModel
import com.example.musclemasterapp.data.ExerciseData
import com.example.musclemasterapp.data.getExercises

@Composable
fun ExerciseScreen(navController: NavController, vm: AppViewModel, exerciseTargetMuscle: String?) {

    val exerciseList = getExercises().filter { exercise ->
        exercise.exerciseTargetMuscle == exerciseTargetMuscle
    }

}