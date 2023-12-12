package com.maxbay.data.network.impl

import com.maxbay.data.models.UserItem
import com.maxbay.data.network.api.UserApi
import com.maxbay.data.network.api.UserApiHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserApiHelperImpl(private val userApi: UserApi): UserApiHelper {
    override fun getAllUsers(): Flow<List<UserItem>> {
        return flow {
            emit(userApi.getAllUsers())
        }
    }
}