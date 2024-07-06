package com.example.sprint_4.ui.userlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sprint_4.data.UserEntity
import com.example.sprint_4.data.UserModelDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(private val userDao: UserModelDAO) : ViewModel() {

    val allUsers: LiveData<List<UserEntity>> = userDao.getAllUsers()


    fun deleteUser(user: UserEntity) = viewModelScope.launch {
        userDao.deleteUser(user)
    }
}
