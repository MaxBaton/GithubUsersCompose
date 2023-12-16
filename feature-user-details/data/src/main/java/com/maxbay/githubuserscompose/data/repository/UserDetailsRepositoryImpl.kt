package com.maxbay.githubuserscompose.data.repository

import com.maxbay.githubuserscompose.data.mappers.toDomain
import com.maxbay.githubuserscompose.data.network.UserDetailsApi
import com.maxbay.githubuserscompose.domain.models.UserDetails
import com.maxbay.githubuserscompose.domain.repository.UserDetailsRepository

class UserDetailsRepositoryImpl(
    private val userDetailsApi: UserDetailsApi
): UserDetailsRepository {
    override suspend fun getUserDetailsById(id: Int): UserDetails {
        return userDetailsApi.getUserDetailsById(id = id).toDomain()
    }
}