package com.maxbay.githubuserscompose.data.storage.database.api

import com.maxbay.githubuserscompose.data.storage.database.dto.UserDetailsDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity


interface DatabaseUserDetailsStorage {
    suspend fun addUserDetails(userDetails: UserDetailsEntity)
    suspend fun getUserDetailsById(id: Int): UserDetailsDto
}