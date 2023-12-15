package com.maxbay.domain.repository

import com.maxbay.domain.models.User
import com.maxbay.domain.models.UserDetails
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun observeUsers(): Flow<List<User>>
    suspend fun searchUsers(search: String)
    suspend fun getUserDetailsById(id: Int): UserDetails
}