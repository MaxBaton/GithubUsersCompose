package com.maxbay.data.network.api

import com.maxbay.data.models.UserItem
import kotlinx.coroutines.flow.Flow

interface UserApiHelper {
    fun getAllUsers(): Flow<List<UserItem>>
}