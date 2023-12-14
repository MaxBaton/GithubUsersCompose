package com.maxbay.data.storage.database.impl

import com.maxbay.data.storage.database.api.DatabaseStorage
import com.maxbay.data.storage.database.dao.UserDao
import com.maxbay.data.storage.database.dto.UserDto
import com.maxbay.data.storage.database.entities.UserEntity

class DatabaseStorageImpl(private val dao: UserDao): DatabaseStorage {
    override suspend fun getAllUsers(): List<UserDto> {
        return dao.getAllUsers()
    }

    override suspend fun addAllUsers(users: List<UserEntity>) {
        dao.addAllUsers(users = users)
    }

    override suspend fun getUserById(id: Int): UserDto {
        return dao.getUserById(id = id)
    }

    override suspend fun getUsersByLoginOrId(value: String): List<UserDto> {
        return dao.getUsersByLoginOrId(value = value)
    }
}