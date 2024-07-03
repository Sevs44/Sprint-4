package com.example.sprint_4.data

class UserRepository {
    private val users = mutableListOf<UserModel>()

    fun getUsers(): List<UserModel> = users

    fun addUser(user: UserModel) {
        users.add(user)
    }

    fun getUserById(id: Int): UserModel? {
        return users.find { it.id == id }
    }
}