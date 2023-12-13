package com.maxbay.data.storage.database.api

import com.maxbay.data.storage.database.dto.UserDto
import kotlinx.coroutines.flow.Flow

interface DatabaseStorage {
    fun getAllUsers(): Flow<List<UserDto>>
}