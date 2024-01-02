package com.maxbay.githubuserscompose.data.storage.database.impl

import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseStorage
import com.maxbay.githubuserscompose.data.storage.database.dao.UserDao
import com.maxbay.githubuserscompose.data.storage.database.dto.UserDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserEntity

class DatabaseStorageImpl(private val dao: UserDao): DatabaseStorage {
    override suspend fun getAllUsers(): List<UserDto> {
        return dao.getAllUsers()
    }

    override suspend fun addAllUsers(users: List<UserEntity>) {
        dao.addAllUsers(users = users)
    }

    override suspend fun getUsersByLoginOrId(value: String): List<UserDto> {
        return dao.getUsersByLoginOrId(value = value)
    }
}