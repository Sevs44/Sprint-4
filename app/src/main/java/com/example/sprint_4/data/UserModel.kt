package com.example.sprint_4.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val favoriteColor: String,
    val birthdate: String,
    @Embedded(prefix = "fav_") val favoriteCityCoordinates: LatLng,
    val favoriteCityName: String,
    val favoriteNumber: Int,
    @Embedded(prefix = "actual_") val actualPosition: LatLng
)