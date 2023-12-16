package com.example.musclemasterapp.data

import androidx.compose.runtime.Composable
import com.example.musclemasterapp.AppViewModel

data class UserData(
    val userId: String? = null,
    val username: String? = null,
    val gender: String? = null,
    val weight: String? = null,
    val height: String? = null,
) {
    fun toMap() = mapOf(
        "userId" to userId,
        "username" to username,
        "gender" to gender,
        "weight" to weight,
        "height" to height
    )
}