package com.example.sprint_4.ui.adduser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint_4.data.UserEntity
import com.example.sprint_4.data.UserModelDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddUserViewModel @Inject constructor(private val userDao: UserModelDAO) : ViewModel() {

    fun insert(user: UserEntity) = viewModelScope.launch {
        userDao.insertUser(user)
    }

}