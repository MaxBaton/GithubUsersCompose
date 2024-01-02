package com.maxbay.githubuserscompose.domain.repository

import com.maxbay.githubuserscompose.domain.models.UserDetails

interface UserDetailsRepository {
    suspend fun getUserDetailsById(id: Int): UserDetails
}