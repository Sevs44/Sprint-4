package com.example.sprint_4.data

class UserRepository {
    private val users = mutableListOf<UserEntity>()

    fun getUsers(): List<UserEntity> = users

    fun addUser(user: UserEntity) {
        users.add(user)
    }

    fun getUserById(id: Int): UserEntity? {
        return users.find { it.id == id }
    }
}