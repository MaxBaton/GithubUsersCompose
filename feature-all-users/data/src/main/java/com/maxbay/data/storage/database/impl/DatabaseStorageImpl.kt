package com.maxbay.data.storage.database.impl

import com.maxbay.data.storage.database.api.DatabaseStorage
import com.maxbay.data.storage.database.dao.UserDao
import com.maxbay.data.storage.database.dto.UserDto
import kotlinx.coroutines.flow.Flow

class DatabaseStorageImpl(private val dao: UserDao): DatabaseStorage {
    override fun getAllUsers(): Flow<List<UserDto>> {
        return dao.getAllUsers()
    }
}