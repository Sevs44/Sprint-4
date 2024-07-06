package com.example.sprint_4.modules

import android.content.Context
import androidx.room.Room
import com.example.sprint_4.data.UserDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(Singleton::class)
object RoomModule {

    private const val USER_DATABASE_NAME = "user_database"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, UserDataBase::class.java, USER_DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideUserDao(db: UserDataBase) = db.userModelDao()
}