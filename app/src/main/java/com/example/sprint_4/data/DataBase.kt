package com.example.sprint_4.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDataBase : RoomDatabase() {

    abstract fun userModelDao(): UserModelDAO
}
