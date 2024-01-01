package com.example.musclemasterapp.api.network

import com.example.musclemasterapp.api.model.MealPlan
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

const val API_KEY = "a94a464ccbf14692aef3a6bdc20c1db9"

@Singleton
interface SpoonacularApi {
    @GET(value = "mealplanner/generate")
    suspend fun getMealPlan(
        @Query("timeFrame") timeFrame: String = "week",
        @Query("targetCalories") targetCalories: String = "2500",
        @Query("apiKey") apiKey: String = API_KEY
    ): MealPlan
}