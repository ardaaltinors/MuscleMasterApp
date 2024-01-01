package com.example.musclemasterapp.api

import androidx.lifecycle.ViewModel
import com.example.musclemasterapp.api.model.MealPlan
import com.example.musclemasterapp.api.repository.MealRepository
import com.example.musclemasterapp.data.DataOrException
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val repository: MealRepository): ViewModel() {

    suspend fun getMealPlanData(targetCalories: String): DataOrException<MealPlan, Boolean, Exception> {
        return repository.getMealPlan(targetCalories)
    }
}