package com.example.sprint_4.data

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val favoriteColor: String,
    val birthdate: Date,
    @Embedded(prefix = "fav_") val favoriteCity: Location,
    val favoriteNumber: Int,
    @Embedded(prefix = "actual_") val actualPosition: Location
)

data class Location(
    @ColumnInfo(name = "latitude") val latitude: Double,
    @ColumnInfo(name = "longitude") val longitude: Double
)