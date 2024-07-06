package com.example.sprint_4.ui.userdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.sprint_4.data.UserEntity
import com.example.sprint_4.data.UserModelDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor(private val userDao: UserModelDAO) : ViewModel() {

    fun getUserById(userId: Int): LiveData<UserEntity?> = liveData {
        val user = userDao.getUserById(userId)
        emit(user)
    }

}