package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.network.api.UserApi
import com.maxbay.domain.models.User
import com.maxbay.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userApi: UserApi
): UserRepository {
    override fun observeUsers(): Flow<List<User>> {
        return userApi.getAllUsers().map { it.users.toDomain() }
    }
}