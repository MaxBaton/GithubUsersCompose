package com.maxbay.domain.repository

import com.maxbay.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun observeUsers(): Flow<List<User>>
}