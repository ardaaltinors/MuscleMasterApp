package com.example.musclemasterapp.api.repository

import android.util.Log
import com.example.musclemasterapp.api.model.MealPlan
import com.example.musclemasterapp.api.network.SpoonacularApi
import com.example.musclemasterapp.data.DataOrException
import javax.inject.Inject

class MealRepository @Inject constructor(private val api: SpoonacularApi) {

    suspend fun getMealPlan(targetCalories: String): DataOrException<MealPlan, Boolean, Exception> {
        val response = try {
            api.getMealPlan(targetCalories = targetCalories)

        } catch (e: Exception) {
            Log.d("GET API exception", "getMealPlan: $e")
            return DataOrException(e = e)
        }
        Log.d("Spoonacular API Response", "response: $response")
        return DataOrException(data = response)
    }
}