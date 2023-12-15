package com.example.musclemasterapp.data

data class UserData(
    val userId: String? = null,
    val username: String? = null,
    val gender: String? = null,
) {
    fun toMap() = mapOf(
        "username" to username,
        "userId" to userId,
        "gender" to gender,
    )
}
