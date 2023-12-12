package com.maxbay.data.repository

import com.maxbay.data.mappers.toDomain
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.network.api.UserApiHelper
import com.maxbay.domain.models.User
import com.maxbay.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val userApiHelper: UserApiHelper
): UserRepository {
    override fun observeUsers(): Flow<List<User>> {
        return userApiHelper.getAllUsers().map { it.toDomain() }
    }
}