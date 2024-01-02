package com.maxbay.githubuserscompose.data.storage.database.impl

import com.maxbay.githubuserscompose.data.storage.database.api.DatabaseUserDetailsStorage
import com.maxbay.githubuserscompose.data.storage.database.dao.UserDetailsDao
import com.maxbay.githubuserscompose.data.storage.database.dto.UserDetailsDto
import com.maxbay.githubuserscompose.data.storage.database.entities.UserDetailsEntity

class DatabaseUserDetailsStorageImpl(private val dao: UserDetailsDao): DatabaseUserDetailsStorage {
    override suspend fun addUserDetails(userDetails: UserDetailsEntity) {
        dao.addUserDetails(userDetails = userDetails)
    }

    override suspend fun getUserDetailsById(id: Int): UserDetailsDto {
        return dao.getUserDetailsById(id = id)
    }
}