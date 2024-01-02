package com.maxbay.githubuserscompose.domain.repository

import com.maxbay.githubuserscompose.domain.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun observeUsers(): Flow<List<User>>
    suspend fun searchUsers(search: String)
}