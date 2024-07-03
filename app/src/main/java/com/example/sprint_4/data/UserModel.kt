package com.example.sprint_4.data

import java.sql.Date

data class UserModel(
    val id: Int,
    val name: String,
    val favoriteColor: String,
    val birthdate: Date,
    val favoriteCity: Location,
    val favoriteNumber: Int,
    val actualPosition: Location
)

data class Location(
    val latitude: Double,
    val longitude: Double
)