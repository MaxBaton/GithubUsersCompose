package com.maxbay.githubuserscompose.data.storage.database.api

import com.maxbay.githubuserscompose.data.storage.database.dto.UserDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserEntity
import kotlinx.coroutines.flow.Flow

interface DatabaseStorage {
    suspend fun getAllUsers(): List<UserDto>
    suspend fun addAllUsers(users: List<UserEntity>)
    suspend fun getUsersByLoginOrId(value: String): List<UserDto>
}